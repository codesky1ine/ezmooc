package com.aszy.ezmooc.service.impl;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aszy.ezmooc.mapper.CourseCatgMapper;
import com.aszy.ezmooc.po.CourseCatg;
import com.aszy.ezmooc.po.CourseCatgExample;
import com.aszy.ezmooc.po.CourseCatgExample.Criteria;
import com.aszy.ezmooc.service.CourseCatgService;

@Service
@SuppressWarnings("unchecked")
public class CourseCatgServiceImpl implements CourseCatgService{
	@Autowired
	CourseCatgMapper ccm;
	
	
	public List<CourseCatg> queryAllCourseCatg() {
		Object[] ob = (Object[]) queryCourseCatg(null, null, null);
		List<CourseCatg> dataList = (List<CourseCatg>) ob[0];
		return dataList;
	}
	
	/**
	 * 通过分类名精确查询
	 */
	public CourseCatg queryCourseCatgByName(String courseCatgName){
		CourseCatgExample c = new CourseCatgExample();
		c.createCriteria().andCourseCatgNameEqualTo(courseCatgName);
		
		List<CourseCatg> dataList = ccm.selectByExample(c);
		return dataList.size() > 0 ? dataList.get(0) : null;
	}
	
	public Object[] queryCourseCatg(CourseCatg cc, Integer page, Integer pageSize) {
		CourseCatgExample cce = new CourseCatgExample();
		Criteria c = cce.createCriteria();
		
		List<CourseCatg> dataList = null;
		
		//分类名搜索
		if(cc != null){
			String ccName = cc.getCourseCatgName();
			if(ccName != null){
				c.andCourseCatgNameLike(ccName);
			}
		}
		
		//分页
		Integer pageCount = null;
		if(page != null && pageSize != null){
			int listCount = ccm.countByExample(cce);
			pageCount = (int) Math.ceil( (float)(listCount) / (float)(pageSize) );
			int startIndex = (page - 1) * pageSize;
			
			if(page > pageCount){
				page = pageSize;
			}
			
			cce.setStartIndex(startIndex);
			cce.setPageSize(pageSize);
		}
		dataList = ccm.selectByExample(cce);
		
		return new Object[]{dataList, pageCount, page};
	}
	
	/**
	 * 根据主键查询课程类别
	 */
	public CourseCatg queryCourseCatgById (String courseCatgId){
		return ccm.selectByPrimaryKey(courseCatgId);
	}
	
	/**
	 * 管理员修改课程类别
	 */
	public int editCourseCatg (CourseCatg courseCatg){
		return ccm.updateByPrimaryKeySelective(courseCatg);
	}
	
	/**
	 * 管理员添加课程类别
	 */
	public int addCourseCatg (CourseCatg courseCatg){
		courseCatg.setCourseCatgId(UUID.randomUUID().toString().replace("-", ""));
		return ccm.insertSelective(courseCatg);
	}
	
	/**
	 * 管理员删除课程类别
	 */
	public int deleteCourseCatg (String courseCatgId){
		return ccm.deleteByPrimaryKey(courseCatgId);
	}
}












