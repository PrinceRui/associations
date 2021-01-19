package com.rui.ass.controller;

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

import java.util.Date;
import java.util.List;

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
        activity.setStatus("1");
        service.save(activity);
    }

    @RequestMapping(value = "submit")
    public void submit(@RequestBody Activity activity) {
        activity.setStatus("2");
        service.save(activity);
    }

    @RequestMapping(value = "pass")
    public void pass(@RequestBody Activity activity) {
        activity.setStatus("3");
        activity.setStartTime(new Date());
        service.save(activity);
    }

    @RequestMapping(value = "back")
    public void back(@RequestBody Activity activity) {
        activity.setStatus("0");
        service.save(activity);
    }

    @RequestMapping("/delete")
    public void delete(@RequestParam String id){
        service.delete(id);
    }

    @RequestMapping("/checkList")
    public List<Activity> checkList(){
        return service.checkList();
    }
}
