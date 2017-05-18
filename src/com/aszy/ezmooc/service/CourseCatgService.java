package com.aszy.ezmooc.service;

import java.util.List;

import com.aszy.ezmooc.po.CourseCatg;

public interface CourseCatgService {
	public List<CourseCatg> queryAllCourseCatg(); 
	
	public CourseCatg queryCourseCatgByName(String courseCatgName);
	
	public Object[] queryCourseCatg(CourseCatg cc, Integer page, Integer pageSize);
	
	public int deleteCourseCatg (String courseCatgId);
	
	public int addCourseCatg (CourseCatg courseCatg);
	
	public int editCourseCatg (CourseCatg cccourseCatg);
	
	public CourseCatg queryCourseCatgById (String courseCatgId);
	
	
}
