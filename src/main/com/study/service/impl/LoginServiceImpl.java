package com.study.service.impl;

import com.study.domain.Login;
import com.study.repository.LoginRepository;
import com.study.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;

/**
 * Created by Administrator on 2017/5/4.
 */
@Service
public class LoginServiceImpl implements LoginService {
    @Autowired
    private LoginRepository loginRepository;
    @Autowired
    private UserServiceImpl userService;

    @Override
    public Login findByPhone(String phone) {
        return loginRepository.findByPhone(phone);
    }

    @Override
    @Transactional
    public String register(String phone, String password) {
        Login login = new Login();
        login.setPhone(phone);
        login.setPassword(password);
        login.setCrDate(new Date());
        loginRepository.save(login);
        return userService.init(phone);
    }



}
