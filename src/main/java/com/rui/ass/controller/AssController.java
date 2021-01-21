package com.rui.ass.controller;

import com.alibaba.fastjson.JSONObject;
import com.rui.ass.entity.AssUser;
import com.rui.ass.service.AssUserService;
import com.rui.framework.annotation.ResponseResult;
import com.rui.framework.controller.BaseController;
import com.rui.framework.entity.Page;
import com.rui.ass.entity.Ass;
import com.rui.ass.service.AssService;
import com.rui.framework.utils.FileUtil;
import com.rui.framework.utils.StringUtils;
import com.rui.sys.entity.User;
import org.apache.shiro.SecurityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@RestController
@ResponseResult
@RequestMapping("/ass/ass")
public class AssController extends BaseController {
    @Autowired
    private AssService service;
    @Autowired
    private AssUserService assUserService;

    @RequestMapping("/get")
    public Ass get(@RequestParam(required=false) String id, HttpServletRequest request){
        if (StringUtils.isNotBlank(id)){
            Ass ass = service.get(id);
            String path = request.getContextPath();
            String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
            ass.setPhoto(basePath + (ass.getPhoto() == null || ass.getPhoto().equals("") ? "upload/logo.jpg" : ass.getPhoto()));
            return ass;
        }else{
            return new Ass();
        }
    }

    @RequestMapping("/list")
    public Page<Ass> findList(@RequestBody Ass ass, HttpServletRequest request){
        String path = request.getContextPath();
        String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
        Page<Ass> page = service.findPageList(ass);
        List<Ass> list = page.getList();
        for (Ass ass1 : list) {
            ass1.setPhoto(basePath + (ass1.getPhoto() == null || ass1.getPhoto().equals("") ? "upload/logo.jpg" : ass1.getPhoto()));
        }
        page.setList(list);
        return page;
    }

    @RequestMapping(value = "save")
    public void save(@RequestBody Ass ass) {
        assUserService.save(new AssUser(ass, ass.getMaster()));
        service.save(ass);
    }

    @RequestMapping("/delete")
    public void delete(@RequestParam String id){
        service.delete(id);
    }

    @RequestMapping("/allList")
    public List<Ass> findAllList(){
        return service.findAllList();
    }

    @RequestMapping("/masterList")
    public List<Ass> findListByMaster(){
        Ass ass = new Ass();
        ass.setMaster((User) SecurityUtils.getSubject().getPrincipal());
        return service.findListByMaster(ass);
    }


    @RequestMapping("/updateLogo")
    public Ass updateLogo(@RequestParam("id") String id, @RequestParam("file") MultipartFile file, HttpServletRequest request) throws Exception{
        String fileName = file.getOriginalFilename();
        String newFileName = FileUtil.renameToUUID(fileName);
        FileUtil.uploadFile(file.getBytes(),request.getRealPath("/upload")+ "\\", newFileName);
        JSONObject json = new JSONObject();
        String path = request.getContextPath();
        String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
        json.put("fileUrl", basePath + "upload/" + newFileName);
        Ass ass = new Ass(id);
        ass.setPhoto("upload/" + newFileName);
        service.updateLogo(ass);
        return get(id, request);
    }

    @RequestMapping("/updateSummary")
    public void updateSummary(@RequestBody Ass ass) {
        service.updateSummary(ass);
    }

}
