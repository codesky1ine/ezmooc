package com.aszy.ezmooc.po;

public class EzUserFavorKey {
    private String userId;

    private String courseId;

    public String getUserId() {
        return userId;
    }

    public EzUserFavorKey(String userId, String courseId) {
		super();
		this.userId = userId;
		this.courseId = courseId;
	}

	public EzUserFavorKey() {
		super();
	}

	public void setUserId(String userId) {
        this.userId = userId == null ? null : userId.trim();
    }

    public String getCourseId() {
        return courseId;
    }

    public void setCourseId(String courseId) {
        this.courseId = courseId == null ? null : courseId.trim();
    }
}