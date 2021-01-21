package com.rui.wx.controller;

import com.alibaba.fastjson.JSONObject;
import com.rui.ass.entity.Activity;
import com.rui.ass.service.ActivityService;
import com.rui.framework.annotation.ResponseResult;
import com.rui.framework.controller.BaseController;
import com.rui.framework.utils.HttpUtil;
import com.rui.sys.entity.User;
import com.rui.sys.service.UserService;
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


}
