package com.rui.ass.controller;

import com.rui.framework.annotation.ResponseResult;
import com.rui.framework.controller.BaseController;
import com.rui.framework.entity.Page;
import com.rui.ass.entity.Ass;
import com.rui.ass.service.AssService;
import com.rui.sys.entity.User;
import org.apache.shiro.SecurityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@ResponseResult
@RequestMapping("/ass/ass")
public class AssController extends BaseController {
    @Autowired
    private AssService service;

    @RequestMapping("/list")
    public Page<Ass> findList(@RequestBody Ass ass){
        return service.findPageList(ass);
    }

    @RequestMapping(value = "save")
    public void save(@RequestBody Ass ass) {
        service.save(ass);
    }

    @RequestMapping("/delete")
    public void delete(@RequestParam String id){
        service.delete(id);
    }

    @RequestMapping("/allList")
    public List<Ass> findAllList(){
        return service.findAllList();
    }

    @RequestMapping("/masterList")
    public List<Ass> findListByMaster(){
        Ass ass = new Ass();
        ass.setMaster((User) SecurityUtils.getSubject().getPrincipal());
        return service.findListByMaster(ass);
    }
}
