package com.aszy.ezmooc.po;

public class Course {
    private String courseId;

    private String courseName;

    private String courseCatgId;

    private CourseCatg courseCatg;

    private String teacherId;

    private String courseImage;

    private String courseInfo;

    private Integer courseViews;

    private String appendTime;
    
    public Course(){
    	courseImage = "/ezmooc/resource/course/default/cimage.png";
    }
    
    public String getCourseCatgId() {
		return courseCatgId;
	}

	public void setCourseCatgId(String courseCatgId) {
		this.courseCatgId = courseCatgId;
	}

	public String getCourseId() {
        return courseId;
    }

    public void setCourseId(String courseId) {
        this.courseId = courseId == null ? null : courseId.trim();
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName == null ? null : courseName.trim();
    }

    public CourseCatg getCourseCatg() {
		return courseCatg;
	}

	public void setCourseCatg(CourseCatg courseCatg) {
		this.courseCatg = courseCatg;
	}

	public String getTeacherId() {
        return teacherId;
    }

    public void setTeacherId(String teacherId) {
        this.teacherId = teacherId == null ? null : teacherId.trim();
    }

    public String getCourseImage() {
        return courseImage;
    }

    public void setCourseImage(String courseImage) {
        this.courseImage = courseImage == null ? null : courseImage.trim();
    }

    public String getCourseInfo() {
        return courseInfo;
    }

    public void setCourseInfo(String courseInfo) {
        this.courseInfo = courseInfo == null ? null : courseInfo.trim();
    }

    public Integer getCourseViews() {
        return courseViews;
    }

    public void setCourseViews(Integer courseViews) {
        this.courseViews = courseViews;
    }

    public String getAppendTime() {
        return appendTime;
    }

    public void setAppendTime(String appendTime) {
        this.appendTime = appendTime == null ? null : appendTime.trim();
    }
}