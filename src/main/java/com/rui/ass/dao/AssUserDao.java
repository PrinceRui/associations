package com.rui.ass.dao;

import com.rui.ass.entity.Ass;
import com.rui.ass.entity.AssUser;
import com.rui.framework.annotation.MyBatisDao;
import com.rui.framework.dao.BaseDao;
import com.rui.sys.entity.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@MyBatisDao
public interface AssUserDao extends BaseDao<AssUser> {
    int countByAss(AssUser entity);
    List<AssUser> findListByUser(@Param("userId") String userId);
    List<AssUser> findListByAss(@Param("assId") String assId);
}
