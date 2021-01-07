package com.rui.sys.dao;

import com.rui.framework.annotation.MyBatisDao;
import com.rui.framework.dao.BaseDao;
import com.rui.sys.entity.Menu;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@MyBatisDao
public interface MenuDao extends BaseDao<Menu> {

    List<Menu> findByUserId(@Param("userId") String userId);

}
