package com.roy.study.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by roy on 2018/5/25.
 */
@Controller
@RequestMapping(value = "/login")
public class LoginController {


    @RequestMapping(value = "/user")
    public String getUserInfo() {

        return "page/login";
    }


}
