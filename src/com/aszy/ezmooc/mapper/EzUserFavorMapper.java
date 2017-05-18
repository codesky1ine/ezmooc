package com.aszy.ezmooc.mapper;

import com.aszy.ezmooc.po.EzUserFavorExample;
import com.aszy.ezmooc.po.EzUserFavorKey;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface EzUserFavorMapper {
    int countByExample(EzUserFavorExample example);

    int deleteByExample(EzUserFavorExample example);

    int deleteByPrimaryKey(EzUserFavorKey key);

    int insert(EzUserFavorKey record);

    int insertSelective(EzUserFavorKey record);

    List<EzUserFavorKey> selectByExample(EzUserFavorExample example);
    
    EzUserFavorKey selectByPrimaryKey(EzUserFavorKey record);

    int updateByExampleSelective(@Param("record") EzUserFavorKey record, @Param("example") EzUserFavorExample example);

    int updateByExample(@Param("record") EzUserFavorKey record, @Param("example") EzUserFavorExample example);
}