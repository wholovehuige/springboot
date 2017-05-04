package com.study.service.impl;

import com.study.domain.User;
import com.study.repository.UserRepository;
import com.study.service.LoginService;
import com.study.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.UUID;

/**
 * Created by Administrator on 2017/4/25.
 */
@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository userRepository;

    public String init(String phone) {
        String uuid = UUID.randomUUID().toString().replaceFirst("-","");
        User user = new User();
        user.setUserId(uuid);
        user.setPhone(phone);
        user.setUserName("");
        user.setRole("");
        user.setEmail("");
        user.setCrDate(new Date());
        user.setUpDate(new Date());
        userRepository.save(user);
        return uuid;
    }

}
