package com.study.controller;

import com.study.properties.Properties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by Administrator on 2017/4/25.
 */
@RestController
public class HelloWorldController {
    @Autowired
    private Properties properties;

    @GetMapping(value = "hello")
    public String getHelloWorld() {

        return "helloWorld";
    }

    @GetMapping(value = "user")
    public String getUserInfo() {
        return "name:" + properties.getName() +"   ==========   "+ "phone:" + properties.getPhone();
    }



}
