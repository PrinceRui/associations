package com.rui.ass.service;

import com.rui.ass.dao.AssDao;
import com.rui.ass.dao.AssUserDao;
import com.rui.ass.entity.Ass;
import com.rui.ass.entity.AssUser;
import com.rui.framework.entity.Page;
import com.rui.framework.service.BaseService;
import com.rui.sys.entity.User;
import org.apache.commons.dbcp.datasources.PerUserPoolDataSource;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(readOnly = true)
public class AssUserService extends BaseService<AssUserDao, AssUser> {

    @Override
    public Page<AssUser> findPageList(AssUser entity) {
        Page<AssUser> page = new Page<>(entity.getPage());
        page.setList(dao.findList(entity));
        page.setCount(dao.countByAss(entity));
        return page;
    }

    @Transactional(readOnly = false)
    public void update(AssUser entity){
        dao.update(entity);
    }

    public List<AssUser> findListByUser(String userId){
        return dao.findListByUser(userId);
    }
    public List<AssUser> findListByAss(String assId){
        return dao.findListByAss(assId);
    }
}
