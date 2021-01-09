package com.rui.framework.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.rui.framework.utils.StringUtils;

import javax.xml.bind.annotation.XmlTransient;
import java.io.Serializable;

/**
 * entity基类
 */
public class BaseEntity<T> implements Serializable {

    private static final long serialVersionUID = 1L;

    protected String id;

    /**
     * 是否是新记录（默认：false），调用setIsNewRecord()设置新记录，使用自定义ID。
     * 设置为true后强制执行插入语句，ID不会自动生成，需从手动传入。
     */
    protected boolean isNewRecord = false;

    /**
     * 是否是新记录（默认：false），调用setIsNewRecord()设置新记录，使用自定义ID。
     * 设置为true后强制执行插入语句，ID不会自动生成，需从手动传入。
     *
     * @return
     */
    public boolean getIsNewRecord() {
        return isNewRecord || StringUtils.isBlank(getId());
    }

    /**
     * 是否是新记录（默认：false），调用setIsNewRecord()设置新记录，使用自定义ID。
     * 设置为true后强制执行插入语句，ID不会自动生成，需从手动传入。
     */
    public void setIsNewRecord(boolean isNewRecord) {
        this.isNewRecord = isNewRecord;
    }

    /**
     * 当前实体分页对象
     */
    protected Page<T> page;

    public Page<T> getPage() {
        if (page == null){
            page = new Page<T>();
        }
        return page;
    }

    public void setPage(Page<T> page) {
        this.page = page;
    }


    public BaseEntity() {
    }

    public BaseEntity(String id) {
        this();
        this.id = id;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

}
