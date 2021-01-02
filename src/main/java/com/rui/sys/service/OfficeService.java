package com.rui.sys.service;

import com.rui.framework.service.BaseService;
import com.rui.framework.utils.StringUtils;
import com.rui.sys.dao.OfficeDao;
import com.rui.sys.entity.Office;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(readOnly = true)
public class OfficeService extends BaseService<OfficeDao, Office> {
    @Override
    public void save(Office entity) {
        String parentId = entity.getParent().getId();
        if (parentId.equals("0")){
            entity.setParentIds("0,");
        }else {
            Office parent = dao.get(entity.getParent().getId());
            entity.setParentIds(parent.getParentIds() + parent.getId() + ",");
        }
        super.save(entity);
    }
}
