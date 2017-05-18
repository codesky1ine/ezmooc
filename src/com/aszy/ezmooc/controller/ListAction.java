package com.aszy.ezmooc.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import net.sf.json.JSONObject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.aszy.ezmooc.po.Course;
import com.aszy.ezmooc.po.CourseCatg;
import com.aszy.ezmooc.service.CourseCatgService;
import com.aszy.ezmooc.service.CourseService;

/**
 * 课程列表
 * @url /ezmooc/list
 * @author aszy
 *
 */
@Controller
public class ListAction {
	
	@Autowired
	CourseService cs;
	
	@Autowired
	CourseCatgService css;
	
	//@RequestMapping(value={"/","/list"})
	@SuppressWarnings({ "unchecked" })
	@RequestMapping("list")
	public String list(HttpServletRequest req, Integer page, String courseCatgId, String sort){
		
		if(page == null){
			page = 1;
		}
		
		//分页查询结果
		Object[] pageData = (Object[]) cs.queryCourse(courseCatgId, page, 12, sort);
		List<Course> courseList = (List<Course>) pageData[0];
		Integer pageCount = (Integer) pageData[1];
		
		for (Course course : courseList) {
			if( course.getCourseImage() == null ){
				course.setCourseImage("/ezmooc/resource/course/default/cimage.png");
			}
		}
		
		
		//课程类别查询
		List<CourseCatg> courseCatgList = css.queryAllCourseCatg();
		
		//json串传输数据至前台
		JSONObject jo = new JSONObject();
		jo.put("courseCatgList", courseCatgList);
		jo.put("courseCatgId", courseCatgId);
		jo.put("page", page);
		jo.put("pageCount", pageCount);
		jo.put("sort", sort);
		
		req.setAttribute("listActionData", jo.toString());
		req.setAttribute("courseList", courseList);
		
		return "course/list";
	}
	
}












