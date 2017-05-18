package com.aszy.ezmooc.service;

import java.util.List;

import com.aszy.ezmooc.po.Video;

public interface VideoService {
	
	public List<Video> queryVideoByCourseId(String courseId);
	
	public Video queryVideoById(String videoId);
	
	public int deleteVideo (String videoId);
	
	public int addVideo (Video video);
	
	public int editVideo (Video video);
	
	public Video queryVideoByName(String videoName);
	
	public Object[] queryVideo(Video video, Integer page, Integer pageSize);
}
