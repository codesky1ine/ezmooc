package com.aszy.ezmooc.po;

public class CourseCatg {

	private String courseCatgId;

    private String courseCatgName;

    public CourseCatg() {
		super();
	}

	public CourseCatg(String courseCatgId, String courseCatgName) {
		super();
		this.courseCatgId = courseCatgId;
		this.courseCatgName = courseCatgName;
	}
    
    public String getCourseCatgId() {
        return courseCatgId;
    }

    public void setCourseCatgId(String courseCatgId) {
        this.courseCatgId = courseCatgId == null ? null : courseCatgId.trim();
    }

    public String getCourseCatgName() {
        return courseCatgName;
    }

    public void setCourseCatgName(String courseCatgName) {
        this.courseCatgName = courseCatgName == null ? null : courseCatgName.trim();
    }
}