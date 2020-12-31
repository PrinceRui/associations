package com.rui.sys.service;

import com.rui.sys.dao.UserDao;
import com.rui.sys.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    @Autowired
    private UserDao dao;

    public List<User> findList(){
        return dao.findList();
    }
}
