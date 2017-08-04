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

    @PostMapping(value = "/register")
//    @ResponseBody
    public String register(RegisterRequest registerRequest) {
        String phone = registerRequest.getPhone();
        String password = registerRequest.getPassword();
        String res =  loginService.register(phone,password);
        return res;
    }


    /**
     * 查询所有
     * @return
     */
    @RequestMapping(value = "/userList")
    @ResponseBody
    public JSONObject getInfo() {
        return userInfoService.findAll();
    }

    @RequestMapping(value = "/updateOne")
    @ResponseBody
    public String updateOne(Long uid,String phone, String name,String username, String state ) {
        boolean res = userInfoService.updateUserInfo(uid,phone,name,state,username);
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

}
