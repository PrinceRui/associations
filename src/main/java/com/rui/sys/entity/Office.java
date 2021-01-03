package com.rui.sys.entity;

import com.rui.framework.entity.BaseEntity;

import java.util.List;

/**
 * 部门班级表
 */
public class Office extends BaseEntity<Office> {
    /**
     * 部门名称
     */
    private String name;
    /**
     * 父部门
     */
    private Office parent;
    /**
     * 所有父部门id（,分隔）
     */
    private String parentIds;
    /**
     * 排序
     */
    private Integer sort;
    /**
     * 类型（1：部门；2：班级）
     */
    private String type;
    /**
     * 负责人
     */
    private User master;
    /**
     * 电话
     */
    private String phone;
    /**
     * 子部门
     */
    private List<Office> childs;

    public Office() {
        super();
    }

    public Office(String id) {
        super(id);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Office getParent() {
        return parent;
    }

    public void setParent(Office parent) {
        this.parent = parent;
    }

    public String getParentIds() {
        return parentIds;
    }

    public void setParentIds(String parentIds) {
        this.parentIds = parentIds;
    }

    public Integer getSort() {
        return sort;
    }

    public void setSort(Integer sort) {
        this.sort = sort;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public User getMaster() {
        return master;
    }

    public void setMaster(User master) {
        this.master = master;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public List<Office> getChilds() {
        return childs;
    }

    public void setChilds(List<Office> childs) {
        this.childs = childs;
    }
}
