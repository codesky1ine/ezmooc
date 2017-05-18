package com.aszy.ezmooc.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.aszy.ezmooc.po.EzUserFollowExample;
import com.aszy.ezmooc.po.EzUserFollowKey;

public interface EzUserFollowMapper {
    int countByExample(EzUserFollowExample example);

    int deleteByExample(EzUserFollowExample example);

    int deleteByPrimaryKey(EzUserFollowKey key);

    int insert(EzUserFollowKey record);

    int insertSelective(EzUserFollowKey record);

    List<EzUserFollowKey> selectByExample(EzUserFollowExample example);
    
    EzUserFollowKey selectByPrimaryKey(EzUserFollowKey record);

    int updateByExampleSelective(@Param("record") EzUserFollowKey record, @Param("example") EzUserFollowExample example);

    int updateByExample(@Param("record") EzUserFollowKey record, @Param("example") EzUserFollowExample example);
}