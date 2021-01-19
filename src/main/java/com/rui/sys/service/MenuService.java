package com.rui.sys.service;

import com.rui.framework.service.BaseService;
import com.rui.sys.dao.MenuDao;
import com.rui.sys.entity.Menu;
import com.rui.sys.entity.User;
import org.apache.ibatis.annotations.Param;
import org.apache.shiro.SecurityUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@Transactional(readOnly = true)
public class MenuService extends BaseService<MenuDao, Menu> {
    @Override
    public void save(Menu entity) {
        String parentId = entity.getParent().getId();
        if (parentId.equals("0")){
            entity.setParentIds("0,");
        }else {
            Menu parent = dao.get(entity.getParent().getId());
            entity.setParentIds(parent.getParentIds() + parent.getId() + ",");
        }
        super.save(entity);
    }

    public List<Menu> findTreeList(Menu menu){
        return listToTree(findList(menu));
    }

    public List<Menu> findByUserId(){
        User user = (User) SecurityUtils.getSubject().getPrincipal();
        List<Menu> list = new ArrayList<>();
        if (user.isAdmin()){
            list = dao.findAllList();
        }else{
            list = dao.findByUserId(user.getId());
        }
        return listToTree(list);
    }

    public List<Menu> findAllTreeList(){
        return listToTree(findAllList());
    }

    private List<Menu> listToTree(List<Menu> list){
        List<Menu> trees = new ArrayList<>();
        for (Menu item : list) {
            /* 获取到根节点 */
            if (item.getParent().getId().equals("0")) {
                trees.add(item);
            }
            /* 遍历获取所有节点下的子节点数据，去除子节点列表中的重复数据 */
            for (Menu it : list) {
                if (it.getParent().getId().equals(item.getId())) {
                    if (item.getChilds() == null) {
                        item.setChilds(new ArrayList<Menu>());
                    }
                    boolean isPut = true;
                    /* 去除子节点列表中的重复数据 */
                    for (Menu childItem : item.getChilds()) {
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
