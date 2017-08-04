package com.study.controller;

import com.study.domain.user.Login;
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

    @RequestMapping(value = "/hello")
    public String getHelloWorld(Model model) {
        model.addAttribute("name","HelloWorld");
        return "page/hello";
    }



    @RequestMapping(value = "/")
    public String register() {

        return "index";
    }


}
