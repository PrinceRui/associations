package com.rui.sys.controller;

import com.rui.framework.annotation.ResponseResult;
import com.rui.framework.controller.BaseController;
import com.rui.framework.utils.StringUtils;
import com.rui.sys.entity.Role;
import com.rui.sys.entity.Role;
import com.rui.sys.service.RoleService;
import com.rui.sys.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@ResponseResult
@RequestMapping("/sys/role")
public class RoleController extends BaseController {
    @Autowired
    private RoleService service;

    @RequestMapping("/get")
    public Role get(@RequestParam(required=false) String id){
        if (StringUtils.isNotBlank(id)){
            return service.get(id);
        }else{
            return new Role();
        }
    }

    @RequestMapping("/list")
    public List<Role> findList(Role role){
        return service.findList(role);
    }

    @RequestMapping("/allList")
    public List<Role> findAllList(){
        return service.findAllList();
    }

    @RequestMapping("/save")
    public void save(Role role){
        service.save(role);
    }

    @RequestMapping(value = "delete")
    public void delete(Role role) {
        service.delete(role);
    }

}
