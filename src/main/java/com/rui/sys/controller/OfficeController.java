package com.rui.sys.controller;

import com.rui.framework.annotation.ResponseResult;
import com.rui.framework.controller.BaseController;
import com.rui.sys.entity.Office;
import com.rui.sys.service.OfficeService;
import com.rui.framework.utils.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
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

    @RequestMapping("/allList")
    public List<Office> findAllList(){
        return service.findAllList();
    }

    @RequestMapping("/treeList")
    public List<Office> findTreeList(@RequestBody Office office){
        return service.findTreeList(office);
    }

    @RequestMapping("/save")
    public void save(@RequestBody Office office){
        service.save(office);
    }

    @RequestMapping("/delete")
    public void delete(@RequestParam String id) {
        service.delete(id);
    }

}
