package com.rui.sys.service;

import com.rui.framework.service.BaseService;
import com.rui.framework.utils.IdGen;
import com.rui.framework.utils.Utils;
import com.rui.sys.dao.RoleDao;
import com.rui.sys.dao.UserDao;
import com.rui.sys.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(readOnly = true)
public class UserService extends BaseService<UserDao, User> {

    @Autowired
    private RoleDao roleDao;

    @Override
    public void save(User entity) {
        if (entity.getIsNewRecord()) {/* 如果是新用户 */
            /* 设置id */
            entity.setId(IdGen.uuid());
            /* 设置默认密码为123456 */
            entity.setPassword(Utils.entryptPassword("123456"));
            /* 设置其为普通用户 */
            roleDao.addUser(entity.getId());
            dao.insert(entity);
        } else {
            dao.update(entity);
        }

    }

    public void updateInfo(User user){
        dao.updateInfo(user);
    }
    public void delWidByid(String id){
        dao.delWidByid(id);
    }

    public void updateWid(User user){
        dao.updateWid(user);
    }

    public User getUserByWid(String wid){
        return dao.getUserByWid(wid);
    }

    public User getUserByNum(String num){
        return dao.getUserByNum(num);
    }

    public void updateImg(User user){
        dao.updateImg(user);
    }

    public void updatePwd(User user){
        dao.updatePwd(user);
    }

    public void resetPassword (String id){
        dao.resetPassword(id, Utils.entryptPassword("123456"));
    }
}
