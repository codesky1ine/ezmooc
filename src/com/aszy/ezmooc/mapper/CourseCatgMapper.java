package com.aszy.ezmooc.mapper;

import com.aszy.ezmooc.po.CourseCatg;
import com.aszy.ezmooc.po.CourseCatgExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface CourseCatgMapper {
    int countByExample(CourseCatgExample example);

    int deleteByExample(CourseCatgExample example);

    int deleteByPrimaryKey(String courseCatgId);

    int insert(CourseCatg record);

    int insertSelective(CourseCatg record);

    List<CourseCatg> selectByExample(CourseCatgExample example);

    CourseCatg selectByPrimaryKey(String courseCatgId);

    int updateByExampleSelective(@Param("record") CourseCatg record, @Param("example") CourseCatgExample example);

    int updateByExample(@Param("record") CourseCatg record, @Param("example") CourseCatgExample example);

    int updateByPrimaryKeySelective(CourseCatg record);

    int updateByPrimaryKey(CourseCatg record);
}