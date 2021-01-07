package com.rui.sys.dao;

import com.rui.framework.annotation.MyBatisDao;
import com.rui.framework.dao.BaseDao;
import com.rui.sys.entity.Role;
import com.rui.sys.entity.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@MyBatisDao
public interface RoleDao extends BaseDao<Role> {
     int auth(@Param("roleId") String roleId, @Param("menuIds") String[] menuIds);
     int assignRole(@Param("roleId") String roleId, @Param("userIds") String[] userIds);
     int addUser(@Param("userId") String userId);
     List<Role> getByUserId(@Param("userId") String userId);
}
