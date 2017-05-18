package com.aszy.ezmooc.po;

public class EzUserFollowKey {
    private String userId;

    private String teacherId;

    public String getUserId() {
        return userId;
    }

    public EzUserFollowKey(String userId, String teacherId) {
		super();
		this.userId = userId;
		this.teacherId = teacherId;
	}

	public EzUserFollowKey() {
		super();
	}

	public void setUserId(String userId) {
        this.userId = userId == null ? null : userId.trim();
    }

    public String getTeacherId() {
        return teacherId;
    }

    public void setTeacherId(String teacherId) {
        this.teacherId = teacherId == null ? null : teacherId.trim();
    }
}