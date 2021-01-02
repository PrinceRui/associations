package com.rui.sys.controller;

import com.rui.framework.annotation.ResponseResult;
import com.rui.sys.entity.User;
import com.rui.sys.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@ResponseResult
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService service;
    @RequestMapping("/list")
    public List<User> findList(){
        return service.findList();
    }
}
