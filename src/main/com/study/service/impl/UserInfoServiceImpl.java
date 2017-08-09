package com.study.service.impl;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.study.domain.user.UserInfo;
import com.study.repository.UserInfoRepository;
import com.study.service.UserInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Administrator on 2017/4/25.
 */
@Service
public class UserInfoServiceImpl implements UserInfoService {
    @Autowired
    private UserInfoRepository userInfoRepository;

    @Override
    public JSONObject findByUid(Long uid) {
        JSONObject jsonObject = new JSONObject();
        UserInfo userInfo = userInfoRepository.findByUid(uid);
        if(userInfo != null) {
            jsonObject.put("username",userInfo.getUsername());
            jsonObject.put("name",userInfo.getName());
            jsonObject.put("uid",userInfo.getUid());
            jsonObject.put("phone",userInfo.getPhone());
            jsonObject.put("state",userInfo.getState());
            jsonObject.put("image",userInfo.getImage());
        }
        return jsonObject;
    }

    @Override
    public boolean updateUserInfo(Long uid ,String phone, String name, String state,String username,String image) {
        if(uid == null) {
            return false;
        }
        UserInfo userInfo = userInfoRepository.findByUid(uid);
        if(userInfo == null) {
            return false;
        }
        userInfo.setPhone(phone);
        userInfo.setName(name);
        userInfo.setState(state);
        userInfo.setImage(image==null?"":image);
        userInfo.setUsername(username);
        userInfoRepository.saveAndFlush(userInfo);
        return true;
    }

    @Override
    public JSONObject findAll(Pageable pageable) {
        JSONObject object = new JSONObject();
        JSONArray jsonArray = new JSONArray();
        Page<UserInfo> userInfos = userInfoRepository.findAll(pageable);
        List<UserInfo> userInfoList = userInfos.getContent();
        for(UserInfo userInfo : userInfoList) {
            JSONObject jsonObject = new JSONObject();
            jsonObject.put("username",userInfo.getUsername());
            jsonObject.put("name",userInfo.getName());
            jsonObject.put("uid",userInfo.getUid());
            jsonObject.put("phone",userInfo.getPhone());
            jsonObject.put("state",userInfo.getState());
            jsonObject.put("image",userInfo.getImage());

            jsonArray.add(jsonObject);
        }
        object.put("data",jsonArray);
        return object;
    }

    @Override
    public UserInfo findByPhone(String phone) {

        return null;
    }

    @Override
    public UserInfo findByUserName(String userName) {
        return userInfoRepository.findByUsername(userName);
    }
}
