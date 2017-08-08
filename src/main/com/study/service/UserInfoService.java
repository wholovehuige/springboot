package com.study.service;


import com.alibaba.fastjson.JSONObject;
import com.study.domain.user.UserInfo;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;


/**
 * Created by Administrator on 2017/5/4.
 */
@Service
public interface UserInfoService {

    JSONObject findByUid(Long uid);

    UserInfo findByPhone(String phone);

    UserInfo findByUserName(String userName);

    JSONObject findAll( Pageable pageable);

    boolean updateUserInfo(Long uid ,String phone,String name,String state,String username);

}
