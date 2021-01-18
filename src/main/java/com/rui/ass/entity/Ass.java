package com.rui.ass.entity;

import com.rui.framework.entity.BaseEntity;
import com.rui.sys.entity.User;

/**
 * 社团管理
 */
public class Ass extends BaseEntity<Ass> {
    private String name;
    private User master;
    private String photo;
    private String summary;

    public Ass() {
        super();
    }

    public Ass(String id) {
        super(id);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public User getMaster() {
        return master;
    }

    public void setMaster(User master) {
        this.master = master;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }
}
