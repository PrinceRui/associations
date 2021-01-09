package com.rui.sys.controller;

import com.rui.framework.annotation.ResponseResult;
import com.rui.framework.controller.BaseController;
import com.rui.framework.entity.Page;
import com.rui.framework.utils.StringUtils;
import com.rui.sys.entity.Dict;
import com.rui.sys.service.DictService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@ResponseResult
@RequestMapping("/sys/dict")
public class DictController extends BaseController {
    @Autowired
    private DictService service;

    @RequestMapping("/list")
    public Page<Dict> findList(@RequestBody Dict dict){
        return service.findPageList(dict);
    }

    @RequestMapping(value = "save")
    public void save(@RequestBody Dict dict) {
        service.save(dict);
    }

    @RequestMapping("/delete")
    public void delete(@RequestParam String id){
        service.delete(id);
    }

    @RequestMapping("/getDictList")
    public List<Dict> getDictList(@RequestParam String type){
        return service.getDictList(type);
    }

}
