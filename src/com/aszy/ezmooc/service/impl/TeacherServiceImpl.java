package com.aszy.ezmooc.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aszy.ezmooc.mapper.EzUserMapper;
import com.aszy.ezmooc.po.Course;
import com.aszy.ezmooc.po.EzUser;
import com.aszy.ezmooc.po.EzUserExample;
import com.aszy.ezmooc.po.EzUserExample.Criteria;
import com.aszy.ezmooc.service.TeacherService;

/**
 * 教师在数据库中的存储方式，与普通用户相同。
 * 都是在EzUser表中，故调用EzUserMapper
 * @author aszy
 *
 */
@Service
public class TeacherServiceImpl implements TeacherService{
	@Autowired
	EzUserMapper um;

	/**
	 * 条件查询教师
	 */
	public Object[] queryTeacher (EzUser teacher, Integer page, Integer pageSize){
		
		EzUserExample ue = new EzUserExample();
		Criteria c = ue.createCriteria();
		c.andRoleIdEqualTo("001");
		
		if(teacher != null){
			//根据教师编号搜索
			String userId = teacher.getUserId();
			if(userId != null){
				c.andUserIdEqualTo(userId);
			}
			
			//根据用户名搜索
			String userName = teacher.getUserName();
			if(userName != null){
				c.andUserNameLike(userName);
			}
		}
		
		ue.setOrderByClause("USER_ID");
		
		
		//分页查询
		List<EzUser> dataList = null;
		Integer pageCount = null;
		
		if(page != null && pageSize != null){
			int listCount = um.countByExample(ue);
			pageCount = (int) Math.ceil( (float)(listCount) / (float)(pageSize) );
			int startIndex = (page - 1) * pageSize;
			
			if(page > pageCount){
				page = pageSize;
			}
			
			ue.setStartIndex(startIndex);
			ue.setPageSize(pageSize);
		}
		dataList = um.selectByExample(ue);
		
		return new Object[]{dataList, pageCount, page};
	}
	
	
	/**
	 * 根据主键查询教师
	 */
	public EzUser queryTeacherById (String teacherId){
		return um.selectByPrimaryKey(teacherId);
	}
	
	/**
	 * 管理员修改教师
	 */
	public int editTeacher (EzUser teacher){
		teacher.setRoleId("001");
		return um.updateByPrimaryKeySelective(teacher);
	}
	
	/**
	 * 管理员添加教师
	 */
	public int addTeacher (EzUser teacher){
		teacher.setRoleId("001");
		return um.insertSelective(teacher);
	}
	
	/**
	 * 管理员删除教师
	 */
	public int deleteTeacher (String teacherId){
		return um.deleteByPrimaryKey(teacherId);
	}
	
}














