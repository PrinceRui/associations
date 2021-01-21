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

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@RestController
@ResponseResult
@RequestMapping("/ass/assUser")
public class AssUserController extends BaseController {
    @Autowired
    private AssUserService service;

    @RequestMapping("/list")
    public Page<AssUser> findList(@RequestBody AssUser assUser, HttpServletRequest request){
        String path = request.getContextPath();
        String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
        Page<AssUser> page = service.findPageList(assUser);
        List<AssUser> list =  page.getList();
        for (AssUser user : list) {
            user.getUser().setPhoto(basePath + (user.getUser().getPhoto() == null || user.getUser().getPhoto().equals("") ? "upload/head.png" : user.getUser().getPhoto()));
        }
        return page;
    }

    @RequestMapping("/save")
    public void save(@RequestBody AssUser assUser){
        service.delete(assUser);
        service.save(assUser);
    }

    @RequestMapping("/delete")
    public void delete(@RequestBody AssUser assUser){
        service.delete(assUser);
    }

}
