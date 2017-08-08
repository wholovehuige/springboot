package com.study.controller;

import com.study.properties.Properties;
import com.study.service.LoginService;
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
    public Long getAllUserCount() {
        Long all = loginService.allUserCount();
        double douAll = all.doubleValue();
        double temp = douAll/5;
        Double count = Math.ceil(temp);
        all = count.longValue();
        return all;
    }


    @RequestMapping(value = "/")
    public String register() {

        return "index";
    }


}
