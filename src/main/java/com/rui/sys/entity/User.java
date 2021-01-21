package com.rui.sys.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.google.common.collect.Lists;
import com.rui.framework.entity.BaseEntity;
import com.rui.framework.utils.Collections3;

import java.util.List;

public class User extends BaseEntity<User> {
    /**
     * 学号工号
     */
    private String num;
    /**
     * 姓名
     */
    private String name;
    /**
     * 密码
     */
    private String password;
    /**
     * 邮箱
     */
    private String email;
    /**
     * 电话
     */
    private String phone;
    /**
     * 头像
     */
    private String photo;
    /**
     * 班级部门
     */
    private Office office;
    /**
     * 用户类型（1:老师，2:学生）
     */
    private String userType;
    /**
     * 微信用户唯一标识
     */
    private String wid;


    public User() {
        super();
    }

    public User(String id) {
        super(id);
    }

    public String getNum() {
        return num;
    }

    public void setNum(String num) {
        this.num = num;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @JsonIgnore
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public Office getOffice() {
        return office;
    }

    public void setOffice(Office office) {
        this.office = office;
    }

    public String getUserType() {
        return userType;
    }

    public void setUserType(String user_type) {
        this.userType = user_type;
    }


    public boolean isAdmin(){
        return isAdmin(this.id);
    }

    public static boolean isAdmin(String id){
        return id != null && "1".equals(id);
    }

    public String getWid() {
        return wid;
    }

    public void setWid(String wid) {
        this.wid = wid;
    }
}
