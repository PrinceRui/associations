package com.rui.sys.service;

import com.rui.framework.service.BaseService;
import com.rui.framework.utils.StringUtils;
import com.rui.sys.dao.OfficeDao;
import com.rui.sys.entity.Office;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

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

    public List<Office> findTreeList(Office office){
        List<Office> list = findList(office);
        List<Office> trees = new ArrayList<>();
        for (Office item : list) {
            /* 获取到根节点 */
            if (item.getParent().getId().equals("0")) {
                trees.add(item);
            }
            /* 遍历获取所有节点下的子节点数据，去除子节点列表中的重复数据 */
            for (Office it : list) {
                if (it.getParent().getId().equals(item.getId())) {
                    if (item.getChilds() == null) {
                        item.setChilds(new ArrayList<Office>());
                    }
                    boolean isPut = true;
                    /* 去除子节点列表中的重复数据 */
                    for (Office childItem : item.getChilds()) {
                        if (it.getParent().getId().equals(childItem.getId())) {
                            isPut = false;
                        }
                    }
                    if (isPut) {
                        item.getChilds().add(it);
                    }
                }
            }
        }
        return trees;
    }
}
