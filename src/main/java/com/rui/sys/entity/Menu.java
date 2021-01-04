package com.rui.sys.entity;

import com.rui.framework.entity.BaseEntity;

import java.util.List;

/**
 * 菜单
 */
public class Menu extends BaseEntity<Menu> {
    /**
     * 菜单名称
     */
    private String name;
    /**
     * 父菜单
     */
    private Office parent;
    /**
     * 所有父菜单id（,分隔）
     */
    private String parentIds;
    /**
     * 排序
     */
    private Integer sort;
    /**
     * 图标
     */
    private String icon;
    /**
     * 是否显示
     */
    private String isShow;
    /**
     * 权限标识
     */
    private String permission;
    /**
     * 子菜单
     */
    private List<Menu> childs;
    /**
     * 组件
     */
    private String component;

    public Menu() {
        super();
    }

    public Menu(String id) {
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

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public String getIsShow() {
        return isShow;
    }

    public void setIsShow(String isShow) {
        this.isShow = isShow;
    }

    public String getPermission() {
        return permission;
    }

    public void setPermission(String permission) {
        this.permission = permission;
    }

    public List<Menu> getChilds() {
        return childs;
    }

    public void setChilds(List<Menu> childs) {
        this.childs = childs;
    }

    public String getComponent() {
        return component;
    }

    public void setComponent(String component) {
        this.component = component;
    }
}
