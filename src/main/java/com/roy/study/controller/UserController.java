package com.roy.tools.controller;

import com.alibaba.fastjson.JSONObject;
import com.roy.tools.constant.StatusCode;
import com.roy.tools.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by Administrator on 2017/4/25.
 */
@Controller
@RequestMapping(value = "/user")
public class UserController {


    @Autowired
    private LoginService userInfoService;



    //注册
    @PostMapping(value = "/register")
    @ResponseBody
    public String register(String phone,String password ) {
        String res =  userInfoService.register(phone,password);
        return res;
    }
    //登陆
    @PostMapping(value = "/submit")
    @ResponseBody
    public StatusCode submit(String phone, String password ) {
        return userInfoService.submit(phone,password);
    }

    /**
     * 查询所有
     * @return
     */
    @RequestMapping(value = "/userList")
    @ResponseBody
    public JSONObject getInfo(int page, int size) {
        return userInfoService.findAll(page,size);
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
