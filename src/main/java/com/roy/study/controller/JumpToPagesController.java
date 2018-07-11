package com.roy.tools.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by roy on 2018/5/25.
 */
@Controller
@RequestMapping(value = "/jump")
public class JumpToPagesController {

    @RequestMapping(value = "/index")
    public String getUserInfo() {
        return "index";
    }


}
