package com.roy.study.service.impl;

import com.roy.study.domain.user.Login;
import com.roy.study.domain.user.UserInfo;
import com.roy.study.repository.LoginRepository;
import com.roy.study.repository.UserInfoRepository;
import com.roy.study.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.UUID;

/**
 * Created by Administrator on 2017/5/4.
 */
@Service
public class LoginServiceImpl implements LoginService{
    @Autowired
    private UserInfoRepository userRepository;
    @Autowired
    private LoginRepository loginRepository;

    @Override
    public String submit(String phone, String password) {
        Login in = loginRepository.findByPhone(phone);
        if(in == null){
            return null;
        }
        String passwd = in.getPassword();
        if(!passwd.equals(passwd)){
            return null;
        }
        return in.getId().toString();
    }

    @Override
    public Integer allUserCount() {
        return userRepository.findAllByStateEquals("1").size();
    }

    @Override
    public String register(String phone, String password) {
        Login in = loginRepository.findByPhone(phone);
        if(in != null) {
            return "该用户已经注册";
        }
        Login login = new Login();
        login.setPhone(phone);
        login.setPassword(password);
        login.setCrDate(new Date());
        login.setUpDate(new Date());
        loginRepository.save(login);
        String uuid = UUID.randomUUID().toString();
        String uid = uuid.replaceAll("-","");
        UserInfo userInfo = new UserInfo();
//        userInfo.setUid(uid);
        userInfo.setPhone(phone);
        userInfo.setPassword(password);
        userInfo.setImage("");
        userInfo.setState("1");
        userInfo.setCrDate(new Date());
        userInfo.setUpDate(new Date());
        userRepository.save(userInfo);
        return uid;
    }
}
