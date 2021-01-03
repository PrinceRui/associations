package com.rui.sys.controller;

import com.rui.framework.annotation.ResponseResult;
import com.rui.framework.controller.BaseController;
import com.rui.framework.utils.StringUtils;
import com.rui.sys.entity.Menu;
import com.rui.sys.service.MenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@ResponseResult
@RequestMapping("/sys/menu")
public class MenuController extends BaseController {
    @Autowired
    private MenuService service;

    @RequestMapping("/get")
    public Menu get(@RequestParam(required=false) String id){
        if (StringUtils.isNotBlank(id)){
            return service.get(id);
        }else{
            return new Menu();
        }
    }

    @RequestMapping("/list")
    public List<Menu> findList(Menu menu){
        return service.findList(menu);
    }

    @RequestMapping("/allList")
    public List<Menu> findAllList(){
        return service.findAllList();
    }

    @RequestMapping("/treeList")
    public List<Menu> findTreeList(){
        return service.findTreeList();
    }

    @RequestMapping("/save")
    public void save(Menu menu){
        service.save(menu);
    }

    @RequestMapping(value = "delete")
    public void delete(Menu menu) {
        service.delete(menu);
    }

}
