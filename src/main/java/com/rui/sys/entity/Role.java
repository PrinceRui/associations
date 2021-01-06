package com.rui.sys.entity;

import com.rui.framework.entity.BaseEntity;

import java.util.List;

/**
 * 权限表
 */
public class Role extends BaseEntity<Role> {
    /**
     * 名称
     */
    private String name;

    /**
     * 授权菜单
     */
    private List<Menu> menuList;

    /**
     * 授权用户
     */
    private List<User> userList;

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

    public List<Menu> getMenuList() {
        return menuList;
    }

    public void setMenuList(List<Menu> menuList) {
        this.menuList = menuList;
    }

    public List<User> getUserList() {
        return userList;
    }

    public void setUserList(List<User> userList) {
        this.userList = userList;
    }
}
