package com.yf.bx.tms.bean;

/**
 * Created by 123 on 2016/10/24.
 */

public class User {

    /**用户id*/
    private String uid;
    /**显示名字*/
    private String name;
    /**密码*/
    private String pwd;
    /**账号信息*/
    private String account;
    /**系统 id */
    private String location;
    private String face;// 英文名字
    private boolean isRememberMe;
    private String headImage;// 头像信息


    public boolean isRememberMe() {
        return isRememberMe;
    }
    public void setRememberMe(boolean isRememberMe) {
        this.isRememberMe = isRememberMe;
    }


    public String getUid() {
        return uid;
    }
    public void setUid(String uid) {
        this.uid = uid;
    }
    public String getLocation() {
        return location;
    }
    public void setLocation(String location) {
        this.location = location;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }


    public String getFace() {
        return face;
    }
    public void setFace(String face) {
        this.face = face;
    }

    public String getAccount() {
        return account;
    }
    public void setAccount(String account) {
        this.account = account;
    }
    public String getPwd() {
        return pwd;
    }
    public void setPwd(String pwd) {
        this.pwd = pwd;
    }
}
