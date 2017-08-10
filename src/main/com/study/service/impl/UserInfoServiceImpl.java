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

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.List;

/**
 * Created by Administrator on 2017/4/25.
 */
@Service
public class UserInfoServiceImpl implements UserInfoService {
    @Autowired
    private UserInfoRepository userInfoRepository;
    @Autowired
    private EntityManager entityManager;

    @Override
    public JSONObject getUserDetail() {
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("Etext","所有的用户");
        jsonObject.put("Esubtext","针对认证和未认证统计");
        //查询总数
        String zero = "select count(*) from user_info where state = '0'";
        //查询state = 1的
        String one = "select count(*) from user_info where state = '1'";
        Query zeroQuery = entityManager.createNativeQuery(zero);
        Query oneQuery = entityManager.createNativeQuery(one);
        List zeroList = zeroQuery.getResultList();
        List oneList = oneQuery.getResultList();
        JSONArray  titleData = new JSONArray();
        titleData.add("已证过");
        titleData.add("未认证");
        JSONArray  dataData = new JSONArray();
        if(zeroList.size()>0) {
            JSONObject object = new JSONObject();
            object.put("value",zeroList.get(0));
            object.put("name","已证过");
            dataData.add(object);
        }
        if(oneList.size()>0) {
            JSONObject object = new JSONObject();
            object.put("value",oneList.get(0));
            object.put("name","未认证");
            dataData.add(object);
        }
        jsonObject.put("titleData",titleData);
        jsonObject.put("dataData",dataData);
        return jsonObject;
    }

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
