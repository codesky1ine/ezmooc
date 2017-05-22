package com.aszy.ezmooc.service.impl;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aszy.ezmooc.common.EzUtils;
import com.aszy.ezmooc.mapper.VideoMapper;
import com.aszy.ezmooc.po.Course;
import com.aszy.ezmooc.po.CourseExample;
import com.aszy.ezmooc.po.Video;
import com.aszy.ezmooc.po.VideoExample;
import com.aszy.ezmooc.po.VideoExample.Criteria;
import com.aszy.ezmooc.service.VideoService;

@Service
@SuppressWarnings("unchecked")
public class VideoServiceImpl implements VideoService{
	@Autowired
	VideoMapper vm;
	
	/**
	 * 根据课程Id查询视频
	 */
	public List<Video> queryVideoByCourseId(String courseId) {
		
		VideoExample ve = new VideoExample();
		ve.createCriteria().andCourseIdEqualTo(courseId);
		ve.setOrderByClause("VIDEO_NAME");
		List<Video> videos = vm.selectByExample(ve);
		
		return videos;
	}
	
	/**
	 * 分页查询、视频名搜索并分页
	 * @param video
	 * @param page
	 * @param pageSize
	 * @return
	 */
	public Object[] queryVideo(Video video, Integer page, Integer pageSize) {
		VideoExample ve = new VideoExample();
		Criteria c = ve.createCriteria();
		
		List<Video> dataList = null;
		
		//视频名搜索
		if(video != null){
			String videoName = video.getVideoName();
			if(videoName != null){
				c.andVideoNameLike(videoName);
			}
		}
		
		c.andTeacherIdEqualTo(EzUtils.loginUser.getUserId());
		
		//分页
		Integer pageCount = null;
		if(page != null && pageSize != null){
			int listCount = vm.countByExample(ve);
			pageCount = (int) Math.ceil( (float)(listCount) / (float)(pageSize) );
			int startIndex = (page - 1) * pageSize;
			
			if(page > pageCount){
				page = pageSize;
			}
			
			ve.setStartIndex(startIndex);
			ve.setPageSize(pageSize);
		}
		ve.setOrderByClause("VIDEO_NAME");
		dataList = vm.selectByExample(ve);
		
		return new Object[]{dataList, pageCount, page};
	}
	
	public Video queryVideoByName(String videoName){
		VideoExample v = new VideoExample();
		v.createCriteria().andVideoNameEqualTo(videoName);
		
		List<Video> dataList = vm.selectByExample(v);
		return dataList.size() > 0 ? dataList.get(0) : null;
	}
	
	/**
	 * 根据视频id查视频
	 */
	public Video queryVideoById(String videoId){
		return vm.selectByPrimaryKey(videoId);
	}
	
	/**
	 * 教师修改视频
	 */
	public int editVideo (Video video){
		return vm.updateByPrimaryKeySelective(video);
	}
	
	/**
	 * 教师添加视频
	 */
	public int addVideo (Video video){
		video.setVideoId(UUID.randomUUID().toString().replace("-", ""));
		return vm.insertSelective(video);
	}
	
	/**
	 * 教师删除视频
	 */
	public int deleteVideo (String videoId){
		return vm.deleteByPrimaryKey(videoId);
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
