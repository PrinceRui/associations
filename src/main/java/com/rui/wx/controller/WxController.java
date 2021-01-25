package com.rui.wx.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.rui.ass.entity.Activity;
import com.rui.ass.entity.Ass;
import com.rui.ass.entity.AssUser;
import com.rui.ass.service.ActivityService;
import com.rui.ass.service.AssService;
import com.rui.ass.service.AssUserService;
import com.rui.framework.annotation.ResponseResult;
import com.rui.framework.controller.BaseController;
import com.rui.framework.utils.HttpUtil;
import com.rui.framework.utils.Utils;
import com.rui.sys.entity.User;
import com.rui.sys.service.UserService;
import com.sun.tools.internal.xjc.reader.xmlschema.bindinfo.BIConversion;
import org.apache.ibatis.executor.ReuseExecutor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static com.rui.wx.constant.WxConstant.*;

@RestController
@RequestMapping("/wx")
public class WxController extends BaseController {

    @Autowired
    private UserService userService;

    @Autowired
    private ActivityService activityService;

    @Autowired
    private AssService assService;

    @Autowired
    private AssUserService assUserService;

    @RequestMapping("/login")
    public JSONObject test(@RequestBody JSONObject json){
        /* 获得临时登录凭证 code */
        String code = json.get("code").toString();
        logger.info("code={}", code);
        /* 封装参数 */
        Map<String, String> param = new HashMap<>();
        param.put("appid", APPID);
        param.put("secret", APP_SECRET);
        param.put("js_code", code);
        param.put("grant_type", "authorization_code");
        /* 登录凭证校验 */
        JSONObject response = HttpUtil.sendGet(CODE_2_SESSION, param);
        /* 获取用户唯一标识 */
        String openid = response.get("openid").toString();
        User user = userService.getUserByWid(openid);
        JSONObject result = new JSONObject();
        result.put("openid", openid);
        result.put("user", user);
        return result;
    }

    @RequestMapping("/bind")
    public JSONObject bind(@RequestBody JSONObject json){
        String username = json.get("username").toString();
        String password = json.get("password").toString();
        String openid = json.get("openid").toString();
        JSONObject result = new JSONObject();
        result.put("openid", openid);
        User user = userService.getUserByNum(username);
        if(user == null){
            result.put("errInfo", "账号不存在");
            return result;
        }
        if(!Utils.validatePassword(password, user.getPassword())){
            result.put("errInfo", "密码错误");
            return result;
        }
        if(user.getWid() != null && !user.getWid().equals("")){
            result.put("errInfo", "该账号已被绑定");
            return result;
        }
        user.setWid(openid);
        userService.updateWid(user);
        result.put("user", user);
        return result;
    }

    @RequestMapping("/logout")
    public void logout(@RequestBody JSONObject json){
        userService.delWidByid(json.get("id").toString());
    }

    @RequestMapping("/activityList")
    public JSONObject activityList(@RequestBody JSONObject json){
        JSONObject result = new JSONObject();
        /* 加入数据 */
        result.put("list", activityService.activityList(Integer.parseInt(json.get("index").toString())));
        /* 加入总数，用来判断是否到底 */
        result.put("count", activityService.countWxList());
        return result;
    }

    @RequestMapping("/getActivity")
    public Activity getActivity(@RequestBody JSONObject json){
        return activityService.get(json.get("id").toString());
    }

    @RequestMapping("/getAss")
    public Ass getAss(@RequestBody JSONObject json){
        Ass ass = assService.get(json.get("id").toString());
        String summary = ass.getSummary();
        //summary = summary.replace("\t", "\\xa0\\xa0\\xa0\\xa0");
        //summary = summary.replace("\t","@@#!");
        //summary = summary.replace(" ","#!@@");
        System.out.println(summary);
        ass.setSummary(summary);
        return ass;
    }

    @RequestMapping("/getAllAss")
    public List<Ass> getAllAss(@RequestBody JSONObject json){
        return assService.findAllList();
    }

    @RequestMapping("/getMyAss")
    public List<AssUser> getMyAss(@RequestBody JSONObject json){
        return assUserService.findListByUser(json.get("id").toString());
    }

    @RequestMapping("/getAssUser")
    public List<AssUser> getAssUser(@RequestBody JSONObject json){
        return assUserService.findListByAss(json.get("id").toString());
    }


}
