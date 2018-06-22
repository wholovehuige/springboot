package com.roy.study.controller;

import com.roy.study.properties.Properties;
import com.roy.study.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

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
        model.addAttribute("count",loginService.allUserCount());
        return "page/hello";
    }

    @RequestMapping(value = "/allUserCount")
    @ResponseBody
    public Integer getAllUserCount() {
        Integer all = loginService.allUserCount();
        double douAll = all.doubleValue();
        double temp = douAll/5;
        Double count = Math.ceil(temp);
        all = count.intValue();
        return all;
    }


    @RequestMapping(value = "/")
    public String register() {

        return "page/login";
    }


}
