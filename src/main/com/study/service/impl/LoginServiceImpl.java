package com.study.service.impl;

import com.study.domain.user.Login;
import com.study.domain.user.UserInfo;
import com.study.repository.LoginRepository;
import com.study.repository.UserInfoRepository;
import com.study.service.LoginService;
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
    public Long allUserCount() {
        return loginRepository.count();
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
        loginRepository.save(login);
        String uuid = UUID.randomUUID().toString();
        String uid = uuid.replaceAll("-","");
        UserInfo userInfo = new UserInfo();
//        userInfo.setUid(uid);
        userInfo.setPhone(phone);
        userInfo.setPassword(password);
        userInfo.setImage("");
        userInfo.setState("0");
        userInfo.setCrDate(new Date());
        userInfo.setUpDate(new Date());
        userRepository.save(userInfo);
        return uid;
    }
}
