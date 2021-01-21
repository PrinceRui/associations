package com.rui.sys.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.rui.framework.annotation.ResponseResult;
import com.rui.framework.controller.BaseController;
import com.rui.framework.entity.Page;
import com.rui.framework.result.Result;
import com.rui.framework.utils.FileUtil;
import com.rui.framework.utils.StringUtils;
import com.rui.framework.utils.Utils;
import com.rui.sys.entity.Menu;
import com.rui.sys.entity.User;
import com.rui.sys.service.UserService;
import org.apache.shiro.SecurityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import static com.rui.framework.result.ResultCode.USER_PWD_ERROR;

@RestController
@ResponseResult
@RequestMapping("/sys/user")
public class UserController extends BaseController {

    @Autowired
    private UserService service;

    @RequestMapping("/get")
    public User get(@RequestParam(required=false) String id){
        if (StringUtils.isNotBlank(id)){
            return service.get(id);
        }else{
            return new User();
        }
    }

    @RequestMapping("/list")
    public Page<User> findList(@RequestBody User user){
        Page<User> page = service.findPageList(user);
        return page;
    }

    @RequestMapping("/save")
    public void save(@RequestBody User user){
        service.save(user);
    }

    @RequestMapping("/updateInfo")
    public void updateInfo(@RequestBody User user){
        service.updateInfo(user);
    }

    @RequestMapping("/updatePwd")
    public Result updatePwd(@RequestBody JSONObject json){
        if(!Utils.validatePassword(json.get("oldPassword").toString(), service.get(json.get("id").toString()).getPassword())){
            return Result.failure(USER_PWD_ERROR);
        }
        User user = new User();
        user.setId(json.get("id").toString());
        user.setPassword(Utils.entryptPassword(json.get("newPassword").toString()));
        service.updatePwd(user);
        return Result.success();
    }

    @RequestMapping("/delete")
    public void delete(@RequestParam String id) {
        service.delete(id);
    }

    @RequestMapping("/resetPassword")
    public void resetPassword(@RequestParam String id){
        service.resetPassword(id);
    }

    @RequestMapping("/imageUpload")
    public JSONObject imageUpload(@RequestParam("file") MultipartFile file, HttpServletRequest request) throws Exception{
        String fileName = file.getOriginalFilename();
        String newFileName = FileUtil.renameToUUID(fileName);
        FileUtil.uploadFile(file.getBytes(),request.getRealPath("/upload")+ "\\", newFileName);
        JSONObject json = new JSONObject();
        String path = request.getContextPath();
        String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
        json.put("fileUrl", basePath + "upload/" + newFileName);
        User user = (User) SecurityUtils.getSubject().getPrincipal();
        user.setPhoto("upload/" + newFileName);
        service.updateImg(user);
        return json;
    }

    /**
     * 仅用于选择，只返回id，num，name
     * @return
     */
    @RequestMapping("/getAllUser")
    public List<JSONObject> getAllUser(){
        List<User> list = service.findAllList();
        List<JSONObject> result = new ArrayList<>();
        for (User user : list) {
            JSONObject json = new JSONObject();
            json.put("id", user.getId());
            json.put("num", user.getNum());
            json.put("name", user.getName());
            result.add(json);
        }
        return result;
    }
}
