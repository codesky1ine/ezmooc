package com.aszy.ezmooc.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import net.sf.json.JSONObject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.aszy.ezmooc.po.Course;
import com.aszy.ezmooc.service.CourseService;

/**
 * 搜索栏及搜索界面
 * @url /ezmooc/search
 * @author aszy
 *
 */
@Controller
@SuppressWarnings({ "rawtypes", "unchecked" })
public class SearchAction {
	@Autowired
	CourseService cs;
	
	/**
	 * 跳转到搜索页面
	 * @return
	 */
	@RequestMapping("/search")
	public String searchPage(HttpServletRequest req, String keyword){
		req.setAttribute("keyword", keyword);
		return "search/search";
	}
	
	/**
	 * 全站搜索	for	ajax
	 * @return
	 */
	@RequestMapping("/search/all")
	public String searchAll(){
		//TODO 全站搜索
		
		return "index";
	}
	
	
	/**
	 * 课程搜索	for	ajax
	 * 
	 * @return
	 */
	
	/*
	 * @RequestBody 接收一个Json字符串 并解析
	 * 
	 * ajax返回乱码：
	 * 		@RequestMapping中加上 produces="application/x-www-form-urlencoded; charset=utf-8"
	 * 
	 * 参考：	http://www.cnblogs.com/quanyongan/archive/2013/04/16/3024741.html
	 * 		http://www.cnblogs.com/dyllove98/p/3180158.html
	 */
	@RequestMapping(value="/search/course", produces="application/x-www-form-urlencoded; charset=utf-8")
	public @ResponseBody String searchCourse(String keyword){
		
		Map params = new HashMap();
		Course course = new Course();
		course.setCourseName(keyword);
		course.setCourseInfo(keyword);
		
		params.put("course", course);
		
		List<Course> courses = (List<Course>) cs.queryCourse(params);
		JSONObject jo = new JSONObject();
		jo.put("courses", courses);
		return jo.toString();
	}
	
}
