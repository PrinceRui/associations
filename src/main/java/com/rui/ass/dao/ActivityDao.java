package com.rui.ass.dao;

import com.rui.ass.entity.Activity;
import com.rui.ass.entity.Ass;
import com.rui.framework.annotation.MyBatisDao;
import com.rui.framework.dao.BaseDao;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@MyBatisDao
public interface ActivityDao extends BaseDao<Activity> {

    List<Activity> checkList();
    Integer countWxList();
    List<Activity> activityList(@Param("index") Integer index);

}
