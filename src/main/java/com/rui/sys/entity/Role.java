package com.rui.sys.entity;

import com.rui.framework.entity.BaseEntity;

/**
 * 权限表
 */
public class Role extends BaseEntity<Role> {
    /**
     * 名称
     */
    private String name;

    public Role() {
        super();
    }

    public Role(String id) {
        super(id);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
