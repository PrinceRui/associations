package com.rui.ass.dao;

import com.rui.ass.entity.Ass;
import com.rui.ass.entity.AssUser;
import com.rui.framework.annotation.MyBatisDao;
import com.rui.framework.dao.BaseDao;
import com.rui.sys.entity.User;

import java.util.List;

@MyBatisDao
public interface AssUserDao extends BaseDao<AssUser> {
    int countByAss(AssUser entity);
}
