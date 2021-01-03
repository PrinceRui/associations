package com.rui.sys.controller;

import com.rui.framework.annotation.ResponseResult;
import com.rui.framework.controller.BaseController;
import com.rui.framework.utils.StringUtils;
import com.rui.sys.entity.Menu;
import com.rui.sys.entity.User;
import com.rui.sys.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@ResponseResult
@RequestMapping("/sys/user")
public class UserController extends BaseController {

    @Autowired
    private UserService service;

    @RequestMapping("/get")
    public User get(@RequestParam(required=false) String id){
        if (StringUtils.isNotBlank(id)){
            return service.get(id);
        }else{
            return new User();
        }
    }

    @RequestMapping("/list")
    public List<User> findList(User user){
        return service.findList(user);
    }

    @RequestMapping("/allList")
    public List<User> findAllList(){
        return service.findAllList();
    }

    @RequestMapping("/save")
    public void save(User user){
        service.save(user);
    }

    @RequestMapping(value = "delete")
    public void delete(User user) {
        service.delete(user);
    }
}
