package com.aszy.ezmooc.po;

public class EzRole {
    private String roleId;

    private String roleName;

    private String courceAceess;

    private String courceCatgAcess;

    private String teacherAcess;

    private String videoAcess;

    public String getRoleId() {
        return roleId;
    }

    public void setRoleId(String roleId) {
        this.roleId = roleId == null ? null : roleId.trim();
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName == null ? null : roleName.trim();
    }

    public String getCourceAceess() {
        return courceAceess;
    }

    public void setCourceAceess(String courceAceess) {
        this.courceAceess = courceAceess == null ? null : courceAceess.trim();
    }

    public String getCourceCatgAcess() {
        return courceCatgAcess;
    }

    public void setCourceCatgAcess(String courceCatgAcess) {
        this.courceCatgAcess = courceCatgAcess == null ? null : courceCatgAcess.trim();
    }

    public String getTeacherAcess() {
        return teacherAcess;
    }

    public void setTeacherAcess(String teacherAcess) {
        this.teacherAcess = teacherAcess == null ? null : teacherAcess.trim();
    }

    public String getVideoAcess() {
        return videoAcess;
    }

    public void setVideoAcess(String videoAcess) {
        this.videoAcess = videoAcess == null ? null : videoAcess.trim();
    }
}