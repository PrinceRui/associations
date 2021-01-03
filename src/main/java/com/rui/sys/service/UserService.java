package com.rui.sys.service;

import com.rui.framework.service.BaseService;
import com.rui.sys.dao.UserDao;
import com.rui.sys.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(readOnly = true)
public class UserService extends BaseService<UserDao, User> {

}
