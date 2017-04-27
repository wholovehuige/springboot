package com.study.controller;

import com.study.properties.Properties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by Administrator on 2017/4/25.
 */
@Controller
public class HelloWorldController {
    @Autowired
    private Properties properties;

    @RequestMapping(value = "hello")
    public String getHelloWorld(Model model) {
        model.addAttribute("name","HelloWorld");
        return "hello";
    }

    @RequestMapping(value = "user")
    public String getUserInfo(Model model) {
        model.addAttribute("name",properties.getName());
        model.addAttribute("phone",properties.getPhone());
        return "user";
    }



}
