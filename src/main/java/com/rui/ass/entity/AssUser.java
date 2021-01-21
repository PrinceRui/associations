package com.rui.ass.entity;

import com.rui.framework.entity.BaseEntity;
import com.rui.sys.entity.User;

/**
 * 社团成员管理
 */
public class AssUser extends BaseEntity<AssUser> {
    private Ass ass;
    private User user;

    public AssUser(Ass ass, User user) {
        this.ass = ass;
        this.user = user;
    }

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

}
