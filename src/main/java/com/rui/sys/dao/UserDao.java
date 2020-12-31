package com.rui.sys.dao;

import com.rui.sys.entity.User;

import java.util.List;

public interface UserDao {
    List<User> findList();
}
