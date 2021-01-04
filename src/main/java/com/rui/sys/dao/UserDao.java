package com.rui.sys.dao;

import com.rui.framework.annotation.MyBatisDao;
import com.rui.framework.dao.BaseDao;
import com.rui.sys.entity.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@MyBatisDao
public interface UserDao extends BaseDao<User> {
    int resetPassword(@Param("id")String id, @Param("password")String password);
}
