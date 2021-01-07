package com.rui.sys.controller;

import com.rui.framework.annotation.ResponseResult;
import com.rui.framework.result.Result;
import com.rui.framework.result.ResultCode;
import com.rui.framework.shiro.FormAuthenticationFilter;
import com.rui.sys.entity.User;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.SimplePrincipalCollection;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.subject.support.DefaultSubjectContext;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.tags.Param;

/**
 * 登录登出控制器
 */
@RestController
public class AdminController {

    @RequestMapping("/404")
    public Result fourZeroFour(){
        return Result.failure(ResultCode.FOUR_ZERO_FOUR);
    }

    @RequestMapping(value = "/login",method = RequestMethod.POST)
    public Result login(){
        return Result.failure(ResultCode.USER_LOGIN_ERROR);
    }


}
