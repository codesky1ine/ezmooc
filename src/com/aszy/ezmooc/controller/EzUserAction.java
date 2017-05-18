package com.aszy.ezmooc.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import net.sf.json.JSONObject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.aszy.ezmooc.common.EzUtils;
import com.aszy.ezmooc.po.Course;
import com.aszy.ezmooc.po.EzUser;
import com.aszy.ezmooc.po.EzUserFavorKey;
import com.aszy.ezmooc.po.EzUserFollowKey;
import com.aszy.ezmooc.service.CourseService;
import com.aszy.ezmooc.service.EzUserService;

/**
 * 用户相关操作
 * @author aszy
 *
 */
@Controller
//@SessionAttributes({"loginUser"})
public class EzUserAction {
	@Autowired
	EzUserService us;
	
	@Autowired
	CourseService cs;
	
	/**
	 * 登录页面
	 * @return
	 */
	@RequestMapping("/login")
	public String loginPage(){
		
		return "user/loginPage";
	} 
	
	/**
	 * 用户注册
	 */
	@RequestMapping("/regist")
	public @ResponseBody void userRegist(EzUser user){
		us.userRegist(user);
	} 
	
	
	/**
	 * 用户注册验证（用户是否存在）
	 */
	@RequestMapping("/regist/valid")
	public @ResponseBody String userRegistValid(EzUser user){
		boolean isRegist = false;
		
		user = us.queryUser(user);
		if(user != null){
			isRegist = true;
		}
		
		//直接用字符串表示true or false。
		//在js中boolean不知道什么时候就变成string了，容易出问题
		JSONObject jo = new JSONObject();
		jo.put("isRegist", ""+isRegist);
		
		return jo.toString();
	} 
	
	
	/**
	 * 用户登录
	 * @return 登录成功则返回对应用户的roleId，失败则返回null
	 */
	/*
	 * @笔记：session设置的几种方法
	 * 
	 * 1. 	置顶注解@SessionAttributes({"user"})
	 * 		参数Model/ModelMap modelMap.addAttribute("user", user);
	 * 
	 * 2.	参数HttpSession httpSession.setAttribute("user", user);
	 * 
	 * 3.	参数HttpServletRequest req.getSession().setAttribute("user", user);
	 */
	@RequestMapping("/userLogin")
	public @ResponseBody String userLogin(HttpServletRequest req, EzUser user){
		
		String roleId = "null";
		
		if(user != null && ( user.getPhone() != null || 
				user.getEmail() != null || user.getUserName() != null) ){
			
			user = us.userLogin(user);
			if(user != null){
				//登录成功
				if(user.getUserIcon() == null){
					user.setUserIcon("/ezmooc/resource/user/default/uimage.jpg");
				}
				req.getSession().setAttribute("loginUser", user);
				EzUtils.loginUser = user;
				
				roleId = user.getRoleId();
			} 
		}
		
		JSONObject jo = new JSONObject();
		jo.put("roleId", roleId);
		
		return jo.toString();
	}
	
	/**
	 * 用户登出
	 * @return
	 */
	/*
	 * @笔记：重定向路径
	 * 例：设当前浏览器url为 /ezmooc/play/userLogout
	 * 	
	 *  绝对路径：redirect:/login	
	 * 	重定向路径则为/ezmooc/login
	 * 
	 *  相对路径：redirect:login
	 *  重定向路径则为/ezmooc/play/login 
	 * 
	 */
	@RequestMapping("/userLogout")
	public String userlogout(HttpServletRequest req){
		req.getSession().removeAttribute("loginUser");
		EzUtils.loginUser = null;
		return "redirect:/login";
	} 
	
	/**
	 * 用户主页
	 * @return
	 */
	@RequestMapping("/user/{userId}")
	public String userHome(@PathVariable("userId") String userId, HttpServletRequest req){
		EzUser user = us.queryUserById(userId);
		List<Course> courses = cs.queryCourseByUserId(userId);
		
		req.setAttribute("user", user);
		req.setAttribute("courses", courses);
		
		return "user/userHome";
	} 
	
	/**
	 * 用户主页编辑
	 * @return
	 */
	@RequestMapping("/user/edit")
	public String userEdit(EzUser user, MultipartFile iconFile, HttpSession session){
		
		EzUser loginUser = (EzUser) session.getAttribute("loginUser");
		String loginUserId = loginUser.getUserId();
		
		if(iconFile != null){
			//D:\\apache-tomcat-6.0.10\\apache-tomcat-6.0.10\\webapps\\ssm\\resourse\\user\\001\\icon.jpg
			String path = session.getServletContext().getRealPath("resource");
			String directory = path+"\\user\\"+loginUserId;
			String iconURL = EzUtils.ezFileUpload(iconFile, directory, "icon");
			user.setUserIcon(iconURL);
		}
		
		user.setUserId(loginUserId);
		us.editUser(user);
		
		//更新完之后，查一次完整的用户数据，作为当前登录用户的数据。
		EzUser editUser = us.queryUserById(loginUserId);
		session.setAttribute("loginUser", editUser);
		
		return "user/userHome";
	} 
	
	/**
	 * 用户收藏课程
	 * @return
	 */
	@RequestMapping("/favor")
	public @ResponseBody String favorCourse(String courseId){
		JSONObject jo = new JSONObject();
		
		if(EzUtils.loginUser != null){
			us.favorCourse( new EzUserFavorKey( 
					EzUtils.loginUser.getUserId(), courseId ) );
			jo.put("isFavor", "true");
		
		}
		return jo.toString();
	} 
	
	/**
	 * 用户取消收藏课程
	 * @return
	 */
	@RequestMapping("/unfavor")
	public @ResponseBody String unfavorCourse(String courseId){
		JSONObject jo = new JSONObject();
		
		if(EzUtils.loginUser != null){
			us.unfavorCourse( new EzUserFavorKey( 
					EzUtils.loginUser.getUserId(), courseId ) );
			jo.put("isFavor", "false");
		
		}
		return jo.toString();
	} 
	
	/**
	 * 用户关注教师
	 * @return
	 */
	@RequestMapping("/follow")
	public @ResponseBody String followTeacher(String teacherId){
		JSONObject jo = new JSONObject();
		
		if(EzUtils.loginUser != null){
			us.followTeacher(new EzUserFollowKey(
					EzUtils.loginUser.getUserId(), teacherId));
			jo.put("isFollow", "true");
			
		}
		return jo.toString();
	} 
	
	/**
	 * 用户取消关注教师
	 * @return
	 */
	@RequestMapping("/unfollow")
	public @ResponseBody String unfollowTeacher(String teacherId){
		JSONObject jo = new JSONObject();
		
		if(EzUtils.loginUser != null){
			us.unfollowTeacher(new EzUserFollowKey(
					EzUtils.loginUser.getUserId(), teacherId));
			jo.put("isFollow", "false");
			
		}
		return jo.toString();
	} 
	
}











