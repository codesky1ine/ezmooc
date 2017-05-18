package com.aszy.ezmooc.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.aszy.ezmooc.common.EzUtils;
import com.aszy.ezmooc.po.Course;
import com.aszy.ezmooc.po.EzUser;
import com.aszy.ezmooc.po.EzUserFavorKey;
import com.aszy.ezmooc.po.EzUserFollowKey;
import com.aszy.ezmooc.po.Video;
import com.aszy.ezmooc.service.CourseService;
import com.aszy.ezmooc.service.EzUserService;
import com.aszy.ezmooc.service.VideoService;

/**
 * 视频播放
 * @url /ezmooc/play/{courseId}/{videoId}
 * @author aszy
 *
 */
@Controller
public class PlayAction {
	@Autowired
	CourseService cs;

	@Autowired
	VideoService vs;
	
	@Autowired
	EzUserService us;
	
	@RequestMapping("/play/{courseId}/{videoId}")
	public String playPage(
			@PathVariable("courseId") String courseId, 
			@PathVariable("videoId") String videoId,
			HttpServletRequest req){
		
		Course course = cs.queryCourseById(courseId);
		EzUser teacher = us.queryUserById( course.getTeacherId() );
		boolean isFavorCourse = false;
		boolean isFollowTeacher = false;
		if(EzUtils.loginUser != null){
			isFavorCourse = us.isFavorCourse( 
					new EzUserFavorKey(EzUtils.loginUser.getUserId(), courseId) );
			isFollowTeacher = us.isFollowTeacher( 
					new EzUserFollowKey(EzUtils.loginUser.getUserId(), teacher.getUserId()) );
		}
		List<Video> videos = vs.queryVideoByCourseId(courseId);
		
		
		//没有指定学习课程下的哪个视频，则默认第一个视频
		Video video = null;
		if(videoId == null && videos.size() > 0){
			videoId = videos.get(0).getVideoId();
		}
		video = vs.queryVideoById(videoId);
		
		req.setAttribute("course", course);
		req.setAttribute("teacher", teacher);
		req.setAttribute("isFollowTeacher", ""+isFollowTeacher);
		req.setAttribute("isFavorCourse", ""+isFavorCourse);
		req.setAttribute("videos", videos);
		req.setAttribute("video", video);
		
		return "course/play";
	}
	
	@RequestMapping("/play/{courseId}")
	public String playPage(@PathVariable("courseId") String courseId, HttpServletRequest req){
		return playPage(courseId, null, req);
	}
	
}














