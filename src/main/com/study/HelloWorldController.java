package com.study;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by Administrator on 2017/4/25.
 */
@RestController
public class HelloWorldController {

    @GetMapping(path = "/hello")
    public String getHelloWorld() {

        return "helloWorld";
    }

}
