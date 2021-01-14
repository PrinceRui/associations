package com.rui.activity.controller;

import com.rui.ass.entity.Activity;
import com.rui.ass.service.ActivityService;
import com.rui.framework.annotation.ResponseResult;
import com.rui.framework.controller.BaseController;
import com.rui.framework.entity.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@ResponseResult
@RequestMapping("/ass/activity")
public class ActivityController extends BaseController {
    @Autowired
    private ActivityService service;

    @RequestMapping("/list")
    public Page<Activity> findList(@RequestBody Activity activity){
        return service.findPageList(activity);
    }

    @RequestMapping(value = "save")
    public void save(@RequestBody Activity activity) {
        service.save(activity);
    }

    @RequestMapping("/delete")
    public void delete(@RequestParam String id){
        service.delete(id);
    }
}
