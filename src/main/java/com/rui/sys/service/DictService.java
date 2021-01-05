package com.rui.sys.service;

import com.rui.framework.service.BaseService;
import com.rui.sys.dao.DictDao;
import com.rui.sys.dao.RoleDao;
import com.rui.sys.entity.Dict;
import com.rui.sys.entity.Role;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Service
@Transactional(readOnly = true)
public class DictService extends BaseService<DictDao, Dict> {

    public List<Dict> getDictList(String type){
        return dao.getDictList(type);
    }

}
