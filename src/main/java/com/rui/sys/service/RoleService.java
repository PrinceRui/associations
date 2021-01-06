package com.rui.sys.service;

import com.rui.framework.service.BaseService;
import com.rui.sys.dao.RoleDao;
import com.rui.sys.dao.UserDao;
import com.rui.sys.entity.Role;
import com.rui.sys.entity.User;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Service
@Transactional(readOnly = true)
public class RoleService extends BaseService<RoleDao, Role> {

    public void auth(String roleId, String[] menuIds) {
        dao.auth(roleId, menuIds);
    }

    public void assignRole(String roleId, String[] userIds) {
        dao.assignRole(roleId, userIds);
    }

}
