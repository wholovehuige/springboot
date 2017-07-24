package com.study.controller;

import com.study.domain.User;
import com.study.repository.UserRepository;
import com.study.service.LoginService;
import com.study.web.request.RegisterRquest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;
import java.util.UUID;

/**
 * Created by Administrator on 2017/4/25.
 */
@RestController
@RequestMapping(value = "/user")
public class UserController {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private LoginService loginService;

    @PostMapping(value = "/register")
    public String register(@RequestParam("password") String password,
                           @RequestParam("phone") String phone) {
//        String phone = registerRquest.getPhone();
//        String password = registerRquest.getPassword();
        return loginService.register(phone,password);
    }

    /**
     * 查询一个
     * @param id
     * @return
     */
    @GetMapping(value = "info")
    public User selectOne(@RequestParam("id") Integer id) {
        return  userRepository.findOne(id);
    }

    /**
     * 查询所有
     * @return
     */
    @GetMapping(value = "userInfo")
    public List<User> getInfo() {
        return userRepository.findAll();
    }

    @PostMapping(value = "info")
    public String userAdd(@RequestParam("userName") String userName,
                          @RequestParam("password") String password,
                          @RequestParam("phone") String phone,
                          @RequestParam("role") String role,
                          @RequestBody String temp) {
        try {
            User user = new User();
            user.setUserId(UUID.randomUUID().toString().replace("-", ""));
            user.setUserName(userName);
            user.setPhone(phone);
            user.setRole(role);
            user.setCrDate(new Date());
            user.setUpDate(new Date());
            userRepository.save(user);
            return "ok";
        }catch (Exception e) {
            return e.getMessage();
        }
    }

}
