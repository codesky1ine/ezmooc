package com.aszy.ezmooc.mapper;

import com.aszy.ezmooc.po.EzUser;
import com.aszy.ezmooc.po.EzUserExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface EzUserMapper {
    int countByExample(EzUserExample example);

    int deleteByExample(EzUserExample example);

    int deleteByPrimaryKey(String userId);

    int insert(EzUser record);

    int insertSelective(EzUser record);

    List<EzUser> selectByExample(EzUserExample example);

    EzUser selectByPrimaryKey(String userId);

    int updateByExampleSelective(@Param("record") EzUser record, @Param("example") EzUserExample example);

    int updateByExample(@Param("record") EzUser record, @Param("example") EzUserExample example);

    int updateByPrimaryKeySelective(EzUser record);

    int updateByPrimaryKey(EzUser record);
}