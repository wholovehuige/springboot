package com.roy.study.controller.rest;

import com.roy.study.properties.QuNiuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by roy on 2017/8/9.
 */
@RestController
public class QiNiuRest {
    @Autowired
    QuNiuService quNiuService;


    @GetMapping(value = "/qiNiu")
    public String qiniuToken() {
        String tken = quNiuService.getQiNiuToken();
        System.out.println("骑牛token" + tken);
        return tken;
    }

}
