package com.rui.ass.service;

import com.rui.ass.dao.AssDao;
import com.rui.ass.entity.Ass;
import com.rui.framework.entity.Page;
import com.rui.framework.service.BaseService;
import com.rui.sys.dao.DictDao;
import com.rui.sys.entity.Dict;
import com.rui.sys.entity.User;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(readOnly = true)
public class AssService extends BaseService<AssDao, Ass> {
    public List<Ass> findListByMaster(Ass ass){
        return dao.findListByMaster(ass);
    }

    @Transactional(readOnly = false)
    public void updateLogo(Ass ass){
        dao.updateLogo(ass);
    }

    @Transactional(readOnly = false)
    public void updateSummary(Ass ass){
        dao.updateSummary(ass);
    }
}
