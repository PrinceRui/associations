package com.rui.ass.entity;

import com.rui.framework.entity.BaseEntity;
import com.rui.sys.entity.User;

/**
 * 活动管理
 */
public class Activity extends BaseEntity<Activity> {
    private String name;
    private Ass ass;
    private String content;
    private String startTime;
    private String endTime;
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

    public String getStartTime() {
        return startTime;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    public String getEndTime() {
        return endTime;
    }

    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
