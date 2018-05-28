package com.study.controller;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.study.domain.user.UserInfo;
import com.study.properties.Properties;
import com.study.repository.UserInfoRepository;
import com.study.service.LoginService;
import com.study.service.UserInfoService;
import com.study.web.request.RegisterRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by Administrator on 2017/4/25.
 */
@Controller
@RequestMapping(value = "/user")
public class UserController {
    @Autowired
    private Properties properties;

    @Autowired
    private LoginService loginService;

    @Autowired
    private UserInfoService userInfoService;

    @RequestMapping(value = "/user")
    public String getUserInfo(Model model) {
        model.addAttribute("name",properties.getName());
        model.addAttribute("phone",properties.getPhone());
        return "page/user";
    }

    //注册
    @PostMapping(value = "/register")
    @ResponseBody
    public String register(RegisterRequest registerRequest) {
        String phone = registerRequest.getPhone();
        String password = registerRequest.getPassword();
        String res =  loginService.register(phone,password);
        return res;
    }
    //登陆
    @PostMapping(value = "/submit")
    @ResponseBody
    public String submit(RegisterRequest registerRequest) {
        String phone = registerRequest.getPhone();
        String password = registerRequest.getPassword();
        String id = loginService.submit(phone,password);
        if(id == null) {
            return "0";
        }
        return "1";
    }

    /**
     * 查询所有
     * @return
     */
    @RequestMapping(value = "/userList")
    @ResponseBody
    public JSONObject getInfo(int page,int size) {
        Pageable pageable = new PageRequest(page,size);
        return userInfoService.findAll(pageable);
    }

    @RequestMapping(value = "/updateOne")
    @ResponseBody
    public String updateOne(Long uid,String phone, String name,String username, String state ,String image) {
        boolean res = userInfoService.updateUserInfo(uid,phone,name,state,username,image);
        if(res) {
            return "ok";
        } else {
            return "no";
        }
    }

    /**
     * 查询一个
     * @return
     */
    @RequestMapping(value = "/oneUser")
    @ResponseBody
    public JSONObject getOne(Long uid) {
        return userInfoService.findByUid(uid);
    }

    /**
     * 删除用户
     * @return
     */
    @RequestMapping(value = "/deleteBy")
    @ResponseBody
    public String deleteBy(Long uid) {
        if(userInfoService.deleteById(uid))
            return "1";
        return "0";
    }



    //页面跳转
    @RequestMapping(value = "/detail")
    public String getUserDetail() {
        return "/page/userDetail";
    }

    @GetMapping(value = "/count")
    @ResponseBody
    public JSONObject getUsercCunt() {
        return userInfoService.getUserDetail();
    }
}
