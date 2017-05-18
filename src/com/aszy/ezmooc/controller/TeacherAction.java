package com.aszy.ezmooc.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import net.sf.json.JSONObject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.aszy.ezmooc.common.EzUtils;
import com.aszy.ezmooc.po.Course;
import com.aszy.ezmooc.po.CourseCatg;
import com.aszy.ezmooc.po.Video;
import com.aszy.ezmooc.service.CourseCatgService;
import com.aszy.ezmooc.service.CourseService;
import com.aszy.ezmooc.service.VideoService;

/**
 * 后台：教师对课程、视频的操作
 * @url /ezmooc/teacher
 * @author aszy
 *
 */
@Controller
@SuppressWarnings({ "unchecked" })
@RequestMapping(value="/teacher", produces="application/x-www-form-urlencoded; charset=utf-8")
public class TeacherAction {
	@Autowired
	CourseService cs;
	
	@Autowired
	CourseCatgService ccs;
	
	@Autowired
	VideoService vs;
	
	/************************************课程管理模块********************************/
	
	/**
	 * 跳转到course.jsp
	 * @return
	 */
	@RequestMapping(value={"", "/course"})
	public String coursePage(){
		return "teacher/course";
	}
	
	/**
	 * 课程列表查询
	 * @param course
	 * @param page
	 * @return
	 */
	@RequestMapping("/course/view")
	public @ResponseBody String courseList(Course course, Integer page){
		
		if(page == null){
			page = 1;
		}
		Object[] param = (Object[]) cs.queryCourse(course == null ? null : course.getCourseName(), page, 8);
		List<Course> courses = (List<Course>) param[0];
		Integer pageCount = (Integer) param[1];
		if(page > pageCount){
			page = pageCount;
		}
		
		JSONObject jo = new JSONObject();
		jo.put("courses", courses);
		jo.put("page", page);
		jo.put("pages", pageCount);
		
		return jo.toString();
	}
	
	/**
	 * 课程分类查询
	 * @return
	 */
	@RequestMapping("/course/courseCatgs")
	public @ResponseBody String findCourseCatgs(){
		List<CourseCatg> courseCatgs = ccs.queryAllCourseCatg();
		JSONObject jo = new JSONObject();
		jo.put("categories", courseCatgs);
		
		return jo.toString();
	}
	
	/**
	 * 修改时的主键查询
	 * @param courseId
	 * @return
	 */
	@RequestMapping("/course/find")
	public @ResponseBody String findCourse(String courseId){
		Course course = cs.queryCourseById(courseId);
		JSONObject jo = new JSONObject();
		jo.put("course", course);
		
		return jo.toString();
	}
	
	/**
	 * 添加、修改时的存在查询
	 * @param courseId
	 * @return
	 */
	@RequestMapping("/course/exist")
	public @ResponseBody String existCourse(String courseName){
		Course course = cs.queryCourseByName(courseName);
		boolean isExist = false;
		if(course != null){
			isExist = true;
		}
		JSONObject jo = new JSONObject();
		jo.put("isExist", isExist);
		
		return jo.toString();
	}
	
	/**
	 * 添加课程
	 * @param imageFile
	 * @param course
	 * @param page
	 * @param session
	 * @return
	 */
	@RequestMapping("/course/add")
	public @ResponseBody String addCourse(MultipartFile imageFile, Course course, Integer page, HttpSession session){
		
		//先添加
		String courseId = cs.addCourse(course);
		course.setCourseId(courseId);
		
		//再修改
		updateCourse(imageFile, course, session);
		return courseList(null,page);
	}
	
	/**
	 * 修改课程
	 * @param imageFile
	 * @param course
	 * @param page
	 * @param session
	 * @return
	 */
	@RequestMapping("/course/update")
	public @ResponseBody String updateCourse(MultipartFile imageFile, Course course, Integer page, HttpSession session){
		updateCourse(imageFile, course, session);
		return courseList(null,page);
	}
	
	/**
	 * 私有方法：修改课程以及文件上传处理
	 * @param imageFile
	 * @param course
	 * @param session
	 * @return
	 */
	private int updateCourse(MultipartFile imageFile, Course course, HttpSession session){
		
		//文件存储路径 D:\\apache-tomcat-6.0.10\\apache-tomcat-6.0.10\\webapps\\ssm\\resource\\course\\001\\cimage.jpg
		if(imageFile != null && imageFile.getSize() > 0){
			String path = session.getServletContext().getRealPath("resource");
			String directory = path+"\\course\\"+course.getCourseId();
			String imageURL = EzUtils.ezFileUpload(imageFile, directory, "cimage");
			course.setCourseImage(imageURL);
		}
		
		return cs.editCourse(course);
	}
	
	/**
	 * 删除课程
	 * @param courseId
	 * @param page
	 * @return
	 */
	@RequestMapping("/course/delete")
	public @ResponseBody String deleteCourse(String courseId, Integer page){
		cs.deleteCourse(courseId);
		return courseList(null,page);
	}
	
	/************************************视频管理模块********************************/
	
	/**
	 * 跳转到video.jsp
	 * @return
	 */
	@RequestMapping("video")
	public String videoPage(){
		return "teacher/video";
	}
	
	/**
	 * 视频列表查询
	 * @param video
	 * @param page
	 * @return
	 */
	@RequestMapping("/video/view")
	public @ResponseBody String videoList(Video video, Integer page){
		
		if(page == null){
			page = 1;
		}
		Object[] param = (Object[]) vs.queryVideo(video == null ? null : video, page, 8);
		List<Video> videos = (List<Video>) param[0];
		Integer pageCount = (Integer) param[1];
		if(page > pageCount){
			page = pageCount;
		}
		
		JSONObject jo = new JSONObject();
		jo.put("videos", videos);
		jo.put("page", page);
		jo.put("pages", pageCount);
		
		return jo.toString();
	}
	/**
	 * 当前教师名下的课程查询
	 * @return
	 */
	@RequestMapping("/video/courses")
	public @ResponseBody String findCourseByTeacher(){
		List<Course> courses = cs.queryCourseByTeacherId(EzUtils.loginUser.getUserId());
		JSONObject jo = new JSONObject();
		jo.put("courses", courses);
		
		return jo.toString();
	}
	
	/**
	 * 修改时的主键查询
	 * @param videoId
	 * @return
	 */
	@RequestMapping("/video/find")
	public @ResponseBody String findVideo(String videoId){
		Video video = vs.queryVideoById(videoId);
		JSONObject jo = new JSONObject();
		jo.put("video", video);
		
		return jo.toString();
	}
	
	/**
	 * 添加、修改时的存在查询
	 * @param videoId
	 * @return
	 */
	@RequestMapping("/video/exist")
	public @ResponseBody String existVideo(String videoName){
		Video video = vs.queryVideoByName(videoName);
		boolean isExist = false;
		if(video != null){
			isExist = true;
		}
		JSONObject jo = new JSONObject();
		jo.put("isExist", isExist);
		
		return jo.toString();
	}
	
	/**
	 * 添加课程
	 * @param videoFile
	 * @param course
	 * @param page
	 * @param session
	 * @return
	 */
	@RequestMapping("/video/add")
	public @ResponseBody String addCourse(Video video, Integer page){
		
		vs.addVideo(video);
		return videoList(null,page);
	}
	
	/**
	 * 修改课程
	 * @param imageFile
	 * @param course
	 * @param page
	 * @param session
	 * @return
	 */
	@RequestMapping("/video/update")
	public @ResponseBody String updateVideo(Video video, Integer page){
		vs.editVideo(video);
		
		
		JSONObject jo = JSONObject.fromObject(videoList(null,page));
		jo.put("editVideoId", video.getVideoId());
		String a = jo.toString();
		return jo.toString();
	}
	
	/**
	 * 视频上传。在修改界面提交修改申请之后，先update基本信息，再通过此方法上传视频并update videoURL
	 * @param imageFile
	 * @param course
	 * @param session
	 * @return
	 */
	@RequestMapping("/video/uploadVideo")
	public @ResponseBody String updateVideo(MultipartFile videoFile, String uploadVideoId, HttpSession session){
		Video video = vs.queryVideoById(uploadVideoId);
		
		//文件存储路径 D:\\apache-tomcat-6.0.10\\apache-tomcat-6.0.10\\webapps\\ssm\\resource\\course\\001\\001.mp4
		if(videoFile != null && videoFile.getSize() > 0){
			String path = session.getServletContext().getRealPath("resource");
			String directory = path+"\\course\\"+video.getCourseId();
			String videoURL = EzUtils.ezFileUpload(videoFile, directory, video.getVideoId());
			
			video.setVideoUrl(videoURL);
			vs.editVideo(video);
		}
		
		JSONObject jo = new JSONObject();
		jo.put("uploadVideoId", video.getVideoId());
		
		return jo.toString();
	}
	
	/**
	 * 删除课程
	 * @param courseId
	 * @param page
	 * @return
	 */
	@RequestMapping("/video/delete")
	public @ResponseBody String deleteVideo(String videoId, Integer page){
		vs.deleteVideo(videoId);
		return videoList(null,page);
	}
	
}














