package com.rui.sys.dao;

import com.rui.framework.annotation.MyBatisDao;
import com.rui.sys.entity.User;

import java.util.List;

@MyBatisDao
public interface UserDao {
    List<User> findList();
}
