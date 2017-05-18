package com.aszy.ezmooc.service;

import com.aszy.ezmooc.po.EzUser;


public interface TeacherService {
	
	public int addTeacher (EzUser teacher);
	
	public Object[] queryTeacher (EzUser teacher, Integer page, Integer pageSize);
	
	public EzUser queryTeacherById (String teacherId);
	
	public int editTeacher (EzUser teacher);
	
	public int deleteTeacher (String teacherId);
}
