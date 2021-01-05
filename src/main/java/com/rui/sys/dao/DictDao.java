package com.rui.sys.dao;

import com.rui.framework.annotation.MyBatisDao;
import com.rui.framework.dao.BaseDao;
import com.rui.sys.entity.Dict;
import com.rui.sys.entity.Role;
import org.apache.ibatis.annotations.Param;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@MyBatisDao
public interface DictDao extends BaseDao<Dict> {

    List<Dict> getDictList(@Param("type") String type);

}
