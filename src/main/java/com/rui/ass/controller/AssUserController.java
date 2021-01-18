package com.rui.ass.controller;

import com.rui.ass.entity.Ass;
import com.rui.ass.entity.AssUser;
import com.rui.ass.service.AssService;
import com.rui.ass.service.AssUserService;
import com.rui.framework.annotation.ResponseResult;
import com.rui.framework.controller.BaseController;
import com.rui.framework.entity.Page;
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
@RequestMapping("/ass/assUser")
public class AssUserController extends BaseController {
    @Autowired
    private AssUserService service;

    @RequestMapping("/list")
    public Page<AssUser> findList(@RequestBody AssUser assUser){
        return service.findPageList(assUser);
    }

    @RequestMapping("/agree")
    public void agree(@RequestBody AssUser assUser){
        assUser.setStatus("1");
        service.update(assUser);
    }

    @RequestMapping("/refuse")
    public void refuse(@RequestBody AssUser assUser){
        assUser.setStatus("2");
        service.update(assUser);
    }

    @RequestMapping("/delete")
    public void delete(@RequestBody AssUser assUser){
        service.delete(assUser);
    }

}
