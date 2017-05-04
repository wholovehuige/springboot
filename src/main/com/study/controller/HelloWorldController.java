package com.study.controller;

import com.study.domain.Login;
import com.study.domain.User;
import com.study.properties.Properties;
import com.study.repository.LoginRepository;
import com.study.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Date;
import java.util.UUID;

/**
 * Created by Administrator on 2017/4/25.
 */
@Controller
public class HelloWorldController {
    @Autowired
    private Properties properties;
    @Autowired
    private LoginRepository loginRepository;
    @Autowired
    private UserRepository userRepository;

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
    public String register(Login loginin,Model model) {
        if(loginin == null || "".equals(loginin.getPhone())) {
            return "";
        }
        Login loginMessage = loginRepository.findByPhone(loginin.getPhone());
        if(loginMessage != null) {
            return "";
        }
        Login login = new Login();
        login.setPhone(loginin.getPhone());
        login.setPassword(loginin.getPassword());
        login.setCrDate(new Date());
        loginRepository.save(login);
        String uuid = UUID.randomUUID().toString();
        String userId = uuid.replaceAll("-","");
        User user = new User();
        user.setUserId(userId);
        user.setPhone(loginin.getPhone());
        user.setUserName("");
        user.setRole("");
        user.setEmail("");
        user.setCrDate(new Date());
        user.setUpDate(new Date());
        userRepository.save(user);
        model.addAttribute("userId",userId);
        return "user";
    }


}
