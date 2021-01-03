package com.rui.sys.controller;

import com.rui.framework.annotation.ResponseResult;
import com.rui.framework.controller.BaseController;
import com.rui.sys.entity.Office;
import com.rui.sys.service.OfficeService;
import com.rui.framework.utils.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.ArrayList;
import java.util.List;

@RestController
@ResponseResult
@RequestMapping("/sys/office")
public class OfficeController extends BaseController {
    @Autowired
    private OfficeService service;

    @RequestMapping("/get")
    public Office get(@RequestParam(required=false) String id){
        if (StringUtils.isNotBlank(id)){
            return service.get(id);
        }else{
            return new Office();
        }
    }

    @RequestMapping("/list")
    public List<Office> findList(Office office){
        return service.findList(office);
    }

    @RequestMapping("/allList")
    public List<Office> findAllList(){
        return service.findAllList();
    }

    @RequestMapping("/treeList")
    public List<Office> findTreeList(){
        return service.findTreeList();
    }

    @RequestMapping("/save")
    public void save(Office office){
        service.save(office);
    }

    @RequestMapping(value = "delete")
    public void delete(Office office) {
        service.delete(office);
    }

}
