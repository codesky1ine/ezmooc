package com.aszy.ezmooc.service;

import com.aszy.ezmooc.po.EzUser;
import com.aszy.ezmooc.po.EzUserFavorKey;
import com.aszy.ezmooc.po.EzUserFollowKey;

public interface EzUserService {
	
	//收藏课程
	public int unfavorCourse (EzUserFavorKey key);
	
	public int favorCourse (EzUserFavorKey key);
	
	public boolean isFavorCourse (EzUserFavorKey key);
	
	//关注教师
	public int unfollowTeacher (EzUserFollowKey key);
	
	public int followTeacher (EzUserFollowKey key);
	
	public boolean isFollowTeacher (EzUserFollowKey key);
	
	//查询
	public EzUser queryUserById (String userId);
	
	public EzUser queryUser (EzUser user);
	
	//修改
	public int editUser (EzUser user);
	
	//登录
	public EzUser userLogin(EzUser user); 
	
	//注册
	public int userRegist (EzUser user);
}
