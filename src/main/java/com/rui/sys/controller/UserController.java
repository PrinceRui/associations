package com.rui.sys.controller;

import com.rui.sys.entity.User;
import com.rui.sys.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService service;
    @RequestMapping("/list")
    public List<User> findList(){
        return service.findList();
    }
}
