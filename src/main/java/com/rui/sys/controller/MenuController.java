package com.rui.sys.controller;

import com.rui.framework.annotation.ResponseResult;
import com.rui.framework.controller.BaseController;
import com.rui.framework.utils.StringUtils;
import com.rui.sys.entity.Menu;
import com.rui.sys.service.MenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
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

    @RequestMapping("/allList")
    public List<Menu> findAllList(){
        return service.findAllList();
    }

    @RequestMapping("/treeList")
    public List<Menu> findTreeList(@RequestBody Menu menu){
        return service.findTreeList(menu);
    }

    @RequestMapping("/allTreeList")
    public List<Menu> findAllTreeList(){
        return service.findAllTreeList();
    }

    @RequestMapping("/save")
    public void save(@RequestBody Menu menu){
        service.save(menu);
    }

    @RequestMapping("/delete")
    public void delete(@RequestParam String id) {
        service.delete(id);
    }

}
