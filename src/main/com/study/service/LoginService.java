package com.study.service;

import com.study.domain.Login;
import org.springframework.stereotype.Component;

/**
 * Created by Administrator on 2017/5/4.
 */
@Component
public interface LoginService {
    Login findByPhone(String phone);

    String register(String phone,String password);
}
