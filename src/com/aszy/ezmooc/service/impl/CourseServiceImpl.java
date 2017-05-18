package com.aszy.ezmooc.service.impl;


import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aszy.ezmooc.common.EzUtils;
import com.aszy.ezmooc.mapper.CourseMapper;
import com.aszy.ezmooc.po.Course;
import com.aszy.ezmooc.po.CourseCatg;
import com.aszy.ezmooc.po.CourseCatgExample;
import com.aszy.ezmooc.po.CourseExample;
import com.aszy.ezmooc.po.CourseExample.Criteria;
import com.aszy.ezmooc.service.CourseService;

@Service
@SuppressWarnings({ "unchecked", "rawtypes" })
public class CourseServiceImpl implements CourseService{
	@Autowired
	CourseMapper cm;
	/**
	 * 条件查询
	 * @param params <br>
	 * course		条件查询参数 	参数类型：Course<br>
	 * page			分页查询页码 	参数类型：Integer<br>
	 * pageSize		每页的数据量 	参数类型：Integer<br>
	 * sort			排序			参数示例：hot / new
	 * 
	 * @return 
	 * 有分页需求返回PageData类型 <br>
	 * 无分页需求返回List类型 <br>
	 * 错误返回null<br>
	 */
	public Object queryCourse(Map params) {
		
		CourseExample courseExample = new CourseExample();
		courseExample.setOrderByClause("COURSE_NAME");
		Criteria criteria = courseExample.createCriteria();
		
		//条件查询
		Course course = (Course) params.get("course"); 
		if(course != null){
			
			//课程名 课程详情 模糊查询
			String courseName = course.getCourseName();
			String courseInfo = course.getCourseInfo();
			if(courseName != null){
				if(courseInfo != null){
					if(courseName.equals(courseInfo)){
						criteria.andCourseNameOrInfoLike(courseName, courseInfo);
					} else{
						criteria.andCourseInfoLike(courseInfo);
					}
				} else {
					criteria.andCourseNameLike(courseName);
				}
			}
			
			//按课程类别ID查询
			if(course.getCourseCatgId() != null){
				String courseCatgId = course.getCourseCatgId();
				if(courseCatgId != null){
					criteria.andCourseCatgIdEqualTo(courseCatgId);
				}
				
			}
			//按教师ID查询
			String teacherId = course.getTeacherId(); 
			if(teacherId != null){
				criteria.andTeacherIdEqualTo(teacherId);
			}
		}
		
		//排序
		String sort = (String) params.get("sort"); 
		if(sort != null){
			//按最新排序
			if("hot".equals(sort)){
				courseExample.setOrderByClause("APPEND_TIME DESC");
				
			//按最热排序
			} else if("new".equals(sort)){
				courseExample.setOrderByClause("COURSE_VIEWS DESC");
			}
		}
		
		//分页查询
		Integer page = (Integer) params.get("page"); 
		if(page != null){
			Integer pageSize = (Integer) params.get("pageSize"); 
			if(page != null && pageSize != null){
				
				int listCount = cm.countByExample(courseExample);
				int pageCount = (int) Math.ceil( (float)(listCount) / (float)(pageSize) );
				int startIndex = (page - 1) * pageSize;
				
				courseExample.setStartIndex(startIndex);
				courseExample.setPageSize(pageSize);
				
				List<Course> dataList = cm.selectByExample(courseExample);
				
				return new Object[]{dataList, pageCount, page};
			}
		//没有分页需求
		} else {
			return cm.selectByExample(courseExample);
		}
		return null;
	}
	
	public Object queryCourse(String courseCatgId, Integer page, Integer pageSize, String sort){
		Map params = new HashMap();
		if(courseCatgId != null){
			Course course = new Course();
			course.setCourseCatgId(courseCatgId);
			params.put("course", course);
		}
		if(sort != null){
			params.put("sort", sort);
		}
		params.put("page", page);
		params.put("pageSize", pageSize);
		return queryCourse(params);
	} 
	
	public Object queryCourse(String keyword, Integer page, Integer pageSize){
		Map params = new HashMap();
		if(keyword != null){
			Course course = new Course();
			course.setCourseName(keyword);
			course.setCourseInfo(keyword);
			params.put("course", course);
		}
		params.put("page", page);
		params.put("pageSize", pageSize);
		return queryCourse(params);
	} 
	
	public Course queryCourseByName(String courseName){
		CourseExample c = new CourseExample();
		c.createCriteria().andCourseNameEqualTo(courseName);
		
		List<Course> dataList = cm.selectByExample(c);
		
		return dataList.size() > 0 ? dataList.get(0) : null;
	}
	
	public List<Course> queryCourseByTeacherId(String teacherId){
		Map params = new HashMap();
		Course course = null;
		course = new Course();
		
		course.setTeacherId(teacherId);
		params.put("course", course);
		List<Course> courses = (List<Course>) queryCourse(params);
		
		return courses == null ? null : courses;
	}
	
	/**
	 * 主键查询
	 * @param courseId
	 */
	public Course queryCourseById(String courseId) {
		return cm.selectByPrimaryKey(courseId);
	}
	
	/**
	 * 用户关注的课程
	 * @param courseId
	 */
	public List<Course> queryCourseByUserId(String userId) {
		return cm.selectByUserId(userId);
	}
	
	/**
	 * 教师修改课程
	 */
	public int editCourse (Course course){
		return cm.updateByPrimaryKeySelective(course);
	}
	
	/**
	 * 教师添加课程
	 */
	public String addCourse (Course course){
		String courseId = UUID.randomUUID().toString().replace("-", "");
		course.setCourseId(courseId);
		//course.setTeacherId(EzUtils.loginUser.getUserId());
		course.setTeacherId("001");
		cm.insertSelective(course);
		return courseId;
	}
	
	/**
	 * 教师删除课程
	 */
	public int deleteCourse (String courseId){
		return cm.deleteByPrimaryKey(courseId);
	}
}









