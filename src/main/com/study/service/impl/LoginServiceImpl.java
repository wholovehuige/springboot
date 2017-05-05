package com.study.service.impl;

import com.study.domain.Login;
import com.study.domain.User;
import com.study.repository.LoginRepository;
import com.study.repository.UserRepository;
import com.study.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.UUID;

/**
 * Created by Administrator on 2017/5/4.
 */
@Service
public class LoginServiceImpl implements LoginService{
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private LoginRepository loginRepository;

    @Override
    public String register(String phone, String password) {
        Login in = loginRepository.findByPhone(phone);
        if(in != null) {
            return "";
        }
        Login login = new Login();
        login.setPhone(phone);
        login.setPassword(password);
        login.setCrDate(new Date());
        loginRepository.save(login);
        String uuid = UUID.randomUUID().toString();
        String userId = uuid.replaceAll("-","");
        User user = new User();
        user.setUserId(userId);
        user.setPhone(phone);
        user.setUserName("");
        user.setRole("");
        user.setEmail("");
        user.setCrDate(new Date());
        user.setUpDate(new Date());
        userRepository.save(user);
        return userId;
    }
}
