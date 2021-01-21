package com.rui.framework.service;

import com.rui.framework.dao.BaseDao;
import com.rui.framework.entity.BaseEntity;
import com.rui.framework.entity.Page;
import com.rui.framework.utils.IdGen;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

/**
 * service基类
 */
@Transactional(readOnly = true)
public class BaseService<Dao extends BaseDao<T>, T extends BaseEntity<T>> {

    /**
     * 持久层对象
     */
    @Autowired
    protected Dao dao;

    /**
     * 获取单条数据
     */
    public T get(String id) {
        return dao.get(id);
    }

    /**
     * 获取单条数据
     */
    public T get(T entity) {
        return dao.get(entity);
    }

    /**
     * 查询列表数据
     */
    public List<T> findList(T entity) {
        return dao.findList(entity);
    }

    /**
     * 分页查询列表数据
     */
    public Page<T> findPageList(T entity) {
        Page<T> page = new Page<>(entity.getPage());
        page.setList(dao.findList(entity));
        page.setCount(dao.count(entity));
        return page;
    }

    /**
     * 查询所有
     * @return
     */
    public List<T> findAllList() {
        return dao.findAllList();
    }

    /**
     * 保存数据（插入或更新）
     *
     * @param entity
     */
    @Transactional(readOnly = false)
    public void save(T entity) {
        int result=0;
        if (entity.getIsNewRecord()) {
            entity.setId(IdGen.uuid());
            result=dao.insert(entity);
        } else {
            result=dao.update(entity);
        }
    }

    /**
     * 删除数据
     */
    @Transactional(readOnly = false)
    public void delete(T entity) {
        dao.delete(entity);
    }

    /**
     * 删除数据
     */
    @Transactional(readOnly = false)
    public void delete(String id) {
        dao.delete(id);
    }

}
