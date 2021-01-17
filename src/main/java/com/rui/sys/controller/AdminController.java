package com.rui.sys.controller;

import com.alibaba.fastjson.JSONObject;
import com.rui.framework.annotation.ResponseResult;
import com.rui.framework.result.Result;
import com.rui.framework.result.ResultCode;
import com.rui.framework.shiro.FormAuthenticationFilter;
import com.rui.sys.entity.User;
import com.sun.tools.internal.xjc.reader.xmlschema.bindinfo.BIConversion;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.SimplePrincipalCollection;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.subject.support.DefaultSubjectContext;
import org.springframework.http.HttpRequest;
import org.springframework.http.server.ServletServerHttpRequest;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.tags.Param;

import javax.servlet.http.HttpServletRequest;

/**
 * 登录登出控制器
 */
@RestController
@ResponseResult
public class AdminController {

    @RequestMapping("/404")
    public Result fourZeroFour(){
        return Result.failure(ResultCode.FOUR_ZERO_FOUR);
    }

    @RequestMapping(value = "/login",method = RequestMethod.POST)
    public Result login(){
        return Result.failure(ResultCode.USER_LOGIN_ERROR);
    }

    @RequestMapping("/userInfo")
    public JSONObject userInfo(HttpServletRequest request){
        User user = (User)SecurityUtils.getSubject().getPrincipal();
        JSONObject json = (JSONObject) JSONObject.toJSON(user);
        String path = request.getContextPath();
        String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
        String photo = basePath + (user.getPhoto() == null || user.getPhoto().equals("") ? "upload/head.png" : user.getPhoto());
        json.put("photo", photo);
        return json;
    }


}
