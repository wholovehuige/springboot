package com.study.controller;

import com.study.domain.Login;
import com.study.properties.Properties;
import com.study.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by Administrator on 2017/4/25.
 */
@Controller
public class HelloWorldController {
    @Autowired
    private Properties properties;
    @Autowired
    private LoginService loginService;

    @RequestMapping(value = "/")
    public String getHelloWorld(Model model) {
        model.addAttribute("name","HelloWorld");
        return "hello";
    }

    @RequestMapping(value = "/user")
    public String getUserInfo(Model model) {
        model.addAttribute("name",properties.getName());
        model.addAttribute("phone",properties.getPhone());
        return "user";
    }


    @PostMapping(value = "/register")
    public String register(Login login,Model model) {
        if(login == null || "".equals(login.getPhone())) {
            return "";
        }
        Login loginMessage = loginService.findByPhone(login.getPhone());
        if(loginMessage != null) {
            return "";
        }
        String uuid = loginService.register(login.getPhone(),login.getPassword());
        model.addAttribute("userId",uuid);
        return "user";
    }


}
