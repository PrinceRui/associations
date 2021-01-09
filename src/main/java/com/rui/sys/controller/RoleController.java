package com.rui.sys.controller;

import com.rui.framework.annotation.ResponseResult;
import com.rui.framework.controller.BaseController;
import com.rui.framework.entity.Page;
import com.rui.framework.utils.StringUtils;
import com.rui.sys.entity.Role;
import com.rui.sys.entity.Role;
import com.rui.sys.service.RoleService;
import com.rui.sys.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
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
    public Page<Role> findList(@RequestBody Role role){
        return service.findPageList(role);
    }

    @RequestMapping("/save")
    public void save(@RequestBody Role role){
        service.save(role);
    }

    @RequestMapping("/delete")
    public void delete(@RequestParam String id) {
        service.delete(id);
    }


    @RequestMapping("/auth")
    public void auth(@RequestParam String roleId, @RequestParam String[] menuIds) {
        service.auth(roleId, menuIds);
    }

    @RequestMapping("/assignRole")
    public void assignRole(@RequestParam String roleId, @RequestParam String[] userIds) {
        service.assignRole(roleId, userIds);
    }

}
