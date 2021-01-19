package com.rui.ass.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.rui.framework.entity.BaseEntity;
import com.rui.sys.entity.User;

import java.util.Date;

/**
 * 活动管理
 */
public class Activity extends BaseEntity<Activity> {
    private String name;
    private Ass ass;
    private String content;
    private Date startTime;
    private String status;


    public Activity() {
        super();
    }

    public Activity(String id) {
        super(id);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Ass getAss() {
        return ass;
    }

    public void setAss(Ass ass) {
        this.ass = ass;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    @JsonFormat(pattern = "yyyy-MM-dd")
    public Date getStartTime() {
        return startTime;
    }

    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
