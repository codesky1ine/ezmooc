package com.aszy.ezmooc.mapper;

import com.aszy.ezmooc.po.EzRole;
import com.aszy.ezmooc.po.EzRoleExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface EzRoleMapper {
    int countByExample(EzRoleExample example);

    int deleteByExample(EzRoleExample example);

    int deleteByPrimaryKey(String roleId);

    int insert(EzRole record);

    int insertSelective(EzRole record);

    List<EzRole> selectByExample(EzRoleExample example);

    EzRole selectByPrimaryKey(String roleId);

    int updateByExampleSelective(@Param("record") EzRole record, @Param("example") EzRoleExample example);

    int updateByExample(@Param("record") EzRole record, @Param("example") EzRoleExample example);

    int updateByPrimaryKeySelective(EzRole record);

    int updateByPrimaryKey(EzRole record);
}