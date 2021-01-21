package com.rui.framework.dao;

import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * dao基类
 * @param <T>
 */
public interface BaseDao<T> {

    /**
     * 获取单条数据
     */
    T get(String id);

    /**
     * 获取单条数据
     */
    T get(T entity);

    /**
     * 获取总数
     */
    int count(T entity);

    /**
     * 查询数据列表
     */
    List<T> findList(T entity);


    /**
     * 查询所有数据列表
     */
    List<T> findAllList();

    /**
     * 插入数据
     */
    int insert(T entity);

    /**
     * 更新数据
     */
    int update(T entity);

    /**
     * 删除数据
     */
    int delete(String id);

    /**
     * 删除数据
     */
    int delete(T entity);

}
