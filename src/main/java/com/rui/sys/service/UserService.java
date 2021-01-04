package com.rui.sys.service;

import com.rui.framework.service.BaseService;
import com.rui.framework.utils.Utils;
import com.rui.sys.dao.UserDao;
import com.rui.sys.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(readOnly = true)
public class UserService extends BaseService<UserDao, User> {

    @Override
    public void save(User entity) {
        /* 默认密码为123456 */
        entity.setPassword(Utils.entryptPassword("123456"));
        super.save(entity);
    }

    public void resetPassword (String id){
        dao.resetPassword(id, Utils.entryptPassword("123456"));
    }
}
