package com.rui.sys.service;

import com.rui.framework.service.BaseService;
import com.rui.sys.dao.RoleDao;
import com.rui.sys.dao.UserDao;
import com.rui.sys.entity.Role;
import com.rui.sys.entity.User;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(readOnly = true)
public class RoleService extends BaseService<RoleDao, Role> {

}
