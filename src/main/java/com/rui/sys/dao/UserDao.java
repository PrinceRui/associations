package com.rui.sys.dao;

import com.rui.framework.annotation.MyBatisDao;
import com.rui.framework.dao.BaseDao;
import com.rui.sys.entity.User;
import org.apache.ibatis.annotations.Param;

@MyBatisDao
public interface UserDao extends BaseDao<User> {
    int resetPassword(@Param("id")String id, @Param("password")String password);
    User getUserByNum(@Param("num")String num);
    User getUserByWid(@Param("wid")String wid);
    int updateInfo(User user);
    int delWidByid(@Param("id")String id);
    int updatePwd(User user);
    int updateImg(User user);
    int updateWid(User user);
}
