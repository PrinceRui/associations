package com.rui.ass.entity;

import com.rui.framework.entity.BaseEntity;
import com.rui.sys.entity.User;

/**
 * 社团成员管理
 */
public class AssUser extends BaseEntity<AssUser> {
    private Ass ass;
    private User user;
    private String status;
    private String info;
    private String remark;

    public AssUser() {
        super();
    }

    public AssUser(String id) {
        super(id);
    }

    public Ass getAss() {
        return ass;
    }

    public void setAss(Ass ass) {
        this.ass = ass;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }
}
