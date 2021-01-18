package com.rui.ass.dao;

import com.rui.ass.entity.Ass;
import com.rui.framework.annotation.MyBatisDao;
import com.rui.framework.dao.BaseDao;
import com.rui.sys.entity.Dict;
import com.rui.sys.entity.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@MyBatisDao
public interface AssDao extends BaseDao<Ass> {
    List<Ass> findListByMaster(Ass ass);
    int updateLogo(Ass ass);
    int updateSummary(Ass ass);
}
