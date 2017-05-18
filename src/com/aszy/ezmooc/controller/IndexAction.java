package com.aszy.ezmooc.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.aszy.ezmooc.service.CourseService;

/**
 * 主页
 * @url /ezmooc
 * @author aszy
 *
 */
@Controller
public class IndexAction {
	@Autowired
	CourseService cs;
	
	@RequestMapping("/")
	public String index(){
		
		
		
		return "index";
	}
	
}
