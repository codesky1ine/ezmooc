package com.aszy.ezmooc.controller;

import java.util.List;

import net.sf.json.JSONObject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.aszy.ezmooc.po.CourseCatg;
import com.aszy.ezmooc.po.EzUser;
import com.aszy.ezmooc.service.CourseCatgService;
import com.aszy.ezmooc.service.TeacherService;

/**
 * 后台：管理员操作教师、课程分类
 * @url /ezmooc/admin
 * @author aszy
 *
 */
@Controller
/*
 * @笔记 	produces用于指定返回数据的格式，避免乱码。
 *			scriptCharset: 'utf-8',
 */
@SuppressWarnings("unchecked")
@RequestMapping(value="/admin", produces="application/x-www-form-urlencoded; charset=utf-8")
public class AdminAction {
	@Autowired
	CourseCatgService ccs;

	@Autowired
	TeacherService ts;
	
	/*************教师管理模块**************/
	
	@RequestMapping(value={"", "/teacher"})
	public String teacherPage(){
		return "admin/teacher";
	}
	
	/**
	 * 教师列表查询
	 * @param teacher
	 * @param page
	 * @return
	 */
	@RequestMapping("/teacher/view")
	public @ResponseBody String teacherList(EzUser teacher, Integer page){
		
		if(page == null || page == 0){
			page = 1;
		}
		Object[] param = ts.queryTeacher(teacher, page, 8);
		List<EzUser> teachers = (List<EzUser>) param[0];
		Integer pageCount = (Integer) param[1];
		if(page > pageCount){
			page = pageCount;
		}
		
		JSONObject jo = new JSONObject();
		jo.put("teachers", teachers);
		jo.put("page", page);
		jo.put("pageCount", pageCount);
		
		return jo.toString();
	}
	
	/**
	 * 查询教师
	 * @param teacherId
	 * @return
	 */
	@RequestMapping("/teacher/find")
	public @ResponseBody String findTeacher(String teacherId){
		EzUser teacher = ts.queryTeacherById(teacherId);
		JSONObject jo = new JSONObject();
		jo.put("teacher", teacher);
		
		return jo.toString();
	}
	
	/**
	 * 查询教师主键是否存在
	 * @param teacherId
	 * @return
	 */
	@RequestMapping("/teacher/exist")
	public @ResponseBody String existTeacher(String teacherId){
		EzUser teacher = ts.queryTeacherById(teacherId);
		boolean isExist = false;
		if(teacher != null){
			isExist = true;
		}
		JSONObject jo = new JSONObject();
		jo.put("isExist", isExist);
		
		return jo.toString();
	}
	
	@RequestMapping("/teacher/add")
	public @ResponseBody String addTeacher(EzUser teacher, Integer page){
		ts.addTeacher(teacher);
		return teacherList(null,page);
	}
	
	@RequestMapping("/teacher/delete")
	public @ResponseBody String deleteTeacher(String teacherId, Integer page){
		ts.deleteTeacher(teacherId);
		return teacherList(null,page);
	}
	
	@RequestMapping("/teacher/update")
	public  @ResponseBody String updateTeacher(EzUser teacher, Integer page){
		ts.editTeacher(teacher);
		return teacherList(null,page);
	}
	
	/*************课程类别管理模块**************/
	
	@RequestMapping("/courseCatg")
	public String courseCatgPage(){
		return "admin/category";
	}
	
	@RequestMapping("/courseCatg/view")
	public @ResponseBody String courseCatgList(CourseCatg cc, Integer page){
		
		if(page == null || page == 0){
			page = 1;
		}
		Object[] param = ccs.queryCourseCatg(cc, page, 8);
		List<CourseCatg> ccs = (List<CourseCatg>) param[0];
		Integer pageCount = (Integer) param[1];
		if(page > pageCount){
			page = pageCount;
		}
		
		JSONObject jo = new JSONObject();
		jo.put("ccs", ccs);
		jo.put("page", page);
		jo.put("pageCount", pageCount);
		
		return jo.toString();
	}
	
	@RequestMapping("/courseCatg/find")
	public @ResponseBody String findCourseCatg(String courseCatgId){
		CourseCatg courseCatg = ccs.queryCourseCatgById(courseCatgId);
		JSONObject jo = new JSONObject();
		jo.put("courseCatg", courseCatg);
		
		return jo.toString();
	}
	
	@RequestMapping("/courseCatg/exist")
	public @ResponseBody String existCourseCatg(String courseCatgName){
		CourseCatg courseCatg = ccs.queryCourseCatgByName(courseCatgName);
		boolean isExist = false;
		if(courseCatg != null){
			isExist = true;
		}
		JSONObject jo = new JSONObject();
		jo.put("isExist", isExist);
		
		return jo.toString();
	}
	
	@RequestMapping("/courseCatg/add")
	public @ResponseBody String addCourseCatg(CourseCatg courseCatg, Integer page){
		ccs.addCourseCatg(courseCatg);
		return courseCatgList(null,page);
	}
	
	@RequestMapping("/courseCatg/delete")
	public @ResponseBody String deleteCourseCatg(String courseCatgId, Integer page){
		ccs.deleteCourseCatg(courseCatgId);
		return courseCatgList(null,page);
	}
	
	@RequestMapping("/courseCatg/update")
	public  @ResponseBody String updateCourseCatg(CourseCatg courseCatg, Integer page){
		ccs.editCourseCatg(courseCatg);
		return courseCatgList(null,page);
	}
	
}























