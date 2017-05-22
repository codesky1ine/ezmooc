package com.aszy.ezmooc.service;

import java.util.List;
import java.util.Map;

import com.aszy.ezmooc.po.Course;

public interface CourseService {
	
	@SuppressWarnings("rawtypes")
	public Object queryCourse(Map params); 
	
	public Object queryCourse(String keyword, String teacherId, Integer page, Integer pageSize);
	
	public Object queryCourse(String courseCatgId, Integer page, Integer pageSize, String sort);
	
	public Course queryCourseById(String courseId); 
	
	public Course queryCourseByName(String courseName);
	
	public List<Course> queryCourseByUserId(String userId);
	
	public List<Course> queryCourseByTeacherId(String teacherId);
	
	public int editCourse (Course course);
	
	/**
	 * @param course
	 * @return courseId
	 */
	public String addCourse (Course course);
	
	public int deleteCourse (String courseId);
}
