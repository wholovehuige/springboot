package com.roy.study.service;


import org.springframework.stereotype.Service;

/**
 * Created by Administrator on 2017/5/4.
 */
@Service
public interface LoginService {
    String register(String phone,String password);

    Integer allUserCount();

    String submit(String phone,String password);
}
