package com.aszy.ezmooc.service.impl;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aszy.ezmooc.mapper.EzUserFavorMapper;
import com.aszy.ezmooc.mapper.EzUserFollowMapper;
import com.aszy.ezmooc.mapper.EzUserMapper;
import com.aszy.ezmooc.po.EzUser;
import com.aszy.ezmooc.po.EzUserExample;
import com.aszy.ezmooc.po.EzUserExample.Criteria;
import com.aszy.ezmooc.po.EzUserFavorKey;
import com.aszy.ezmooc.po.EzUserFollowKey;
import com.aszy.ezmooc.service.EzUserService;

@Service
public class EzUserServiceImpl implements EzUserService{
	@Autowired
	EzUserMapper um;

	@Autowired
	EzUserFavorMapper favorm;
	
	@Autowired
	EzUserFollowMapper followm;
	
	/**
	 * 用户登录
	 * @return 
	 * 返回user : 登录成功<br>
	 * 返回null : 登录失败<br>
	 */
	public EzUser userLogin(EzUser loginUser) {
		
		EzUser user = queryUser(loginUser);
		
		if(user != null){
			if(loginUser.getPassword().equals( user.getPassword() )){
				//登录成功
				return user;
			}
		}
		
		return null;
	}
	
	/**
	 * 根据用户名/手机/邮箱 查询用户
	 */
	public EzUser queryUser (EzUser user){
		
		EzUserExample ue = new EzUserExample();
		Criteria c = ue.createCriteria();
		
		//根据手机查询
		String phone = user.getPhone();
		if(phone != null){
			c.andPhoneEqualTo(phone);
		}
		
		//根据邮箱查询
		String email = user.getEmail();
		if(email != null){
			c.andEmailEqualTo(email);
		}
		
		//根据用户名查询
		String userName = user.getUserName();
		if(userName != null){
			c.andUserNameEqualTo(userName);
		}
		
		List<EzUser> list = um.selectByExample(ue);
		if(list.size() > 0){
			return list.get(0);
		}
		
		return null;
	}
	
	
	/**
	 * 根据主键查询用户
	 */
	public EzUser queryUserById (String userId){
		return um.selectByPrimaryKey(userId);
	}
	
	
	/**
	 * 用户修改
	 */
	public int editUser (EzUser user){
		return um.updateByPrimaryKeySelective(user);
	}
	
	/**
	 * 用户收藏课程
	 */
	public int favorCourse (EzUserFavorKey key){
		return favorm.insert(key);
	}
	
	/**
	 * 用户取消收藏课程
	 */
	public int unfavorCourse (EzUserFavorKey key){
		return favorm.deleteByPrimaryKey(key);
	}
	
	/**
	 * 用户是否已收藏该课程
	 */
	public boolean isFavorCourse (EzUserFavorKey key){
		boolean isFavor = false;
		if(favorm.selectByPrimaryKey(key) != null){
			isFavor = true;
		}
		return isFavor;
	}
	
	/**
	 * 用户关注教师
	 */
	public int followTeacher (EzUserFollowKey key){
		return followm.insert(key);
	}
	
	/**
	 * 用户取消关注教师
	 */
	public int unfollowTeacher (EzUserFollowKey key){
		return followm.deleteByPrimaryKey(key);
	}
	
	/**
	 * 用户是否已收藏该课程
	 */
	public boolean isFollowTeacher (EzUserFollowKey key){
		boolean isFollow = false;
		if(followm.selectByPrimaryKey(key) != null){
			isFollow = true;
		}
		return isFollow;
	}

	/**
	 * 用户注册
	 */
	public int userRegist (EzUser user){
		user.setUserId( 
				UUID.randomUUID().toString().replace("-", "") );
		user.setRoleId("002");
		return um.insert(user);
	}
	
}














