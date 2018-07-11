package com.roy.tools.service;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.roy.tools.constant.StatusCode;
import com.roy.tools.mapper.UserMapper;
import com.roy.tools.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;


/**
 * Created by Administrator on 2017/5/4.
 */
@Service
public class LoginService {


    @Autowired
    private UserMapper userMapper;

    public StatusCode submit(String phone, String password) {
        HashMap user = userMapper.findByPhone(phone);
        if(user == null ){
            System.out.println("用户不存在");
            return StatusCode.LOGIN_UNKNOW_ERROR;
        }
        String passwd = (String) user.get("password");
        if(!passwd.equals(passwd)){
            return StatusCode.LOGIN_ERROR;
        }
        return StatusCode.REGISTER_OK;
    }

    public Integer allUserCount() {
//        EntityWrapper<User> ew = new EntityWrapper<>();
//        ew.where("state = {0}","1");

        return userMapper.selectCount(new EntityWrapper<User>().where("state={0}","1"));
//        List<User> userList =  userMapper.selectList(ew);
//        return userList.size();
    }

    public String register(String phone, String password) {
        User user = new User();
        user.setPhone(phone);
        user = userMapper.selectOne(user);
        if(user != null) {
            return "该用户已经注册";
        }
        user.setPassword(password);
        Integer id = userMapper.insert(user);
        return id.toString();
    }

    public JSONObject getUserDetail() {
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("Etext", "所有的用户");
        jsonObject.put("Esubtext", "针对认证和未认证统计");

        EntityWrapper<User> ewOne = new EntityWrapper<>();
        EntityWrapper<User> ewZero = new EntityWrapper<>();
        ewOne.where("state = {0}","1");
        List<User> oneList = userMapper.selectList(ewOne);
        ewZero.where("state = {0}","0");
        List<User> zeroList = userMapper.selectList(ewZero);
        JSONArray titleData = new JSONArray();
        titleData.add("作废用户");
        titleData.add("活跃用户");
        JSONArray dataData = new JSONArray();
        if (zeroList.size() > 0) {
            JSONObject object = new JSONObject();
            object.put("value", zeroList.size());
            object.put("name", "作废用户");
            dataData.add(object);
        }
        if (oneList.size() > 0) {
            JSONObject object = new JSONObject();
            object.put("value", oneList.size());
            object.put("name", "活跃用户");
            dataData.add(object);
        }
        jsonObject.put("titleData", titleData);
        jsonObject.put("dataData", dataData);
        return jsonObject;
    }

    public JSONObject findByUid(Long uid) {
        JSONObject jsonObject = new JSONObject();
        User userInfo = userMapper.selectById(uid);
        if (userInfo != null) {
            jsonObject.put("username", userInfo.getUsername());
            jsonObject.put("name", userInfo.getName());
            jsonObject.put("uid", userInfo.getId());
            jsonObject.put("phone", userInfo.getPhone());
            jsonObject.put("state", userInfo.getState());
            jsonObject.put("image", userInfo.getImage());
        }
        return jsonObject;
    }

    public boolean updateUserInfo(Long uid, String phone, String name, String state, String username, String image) {
        if (uid == null) {
            return false;
        }
        User userInfo = userMapper.selectById(uid);
        if (userInfo == null) {
            return false;
        }
        userInfo.setPhone(phone);
        userInfo.setName(name);
        userInfo.setState(state);
        userInfo.setImage(image == null ? "" : image);
        userInfo.setUsername(username);
        userMapper.updateById(userInfo);
        return true;
    }

    public JSONObject findAll(int pageable, int size) {
        Page<User> page = new Page<>(pageable, size);
        EntityWrapper<User> ew = new EntityWrapper<>();
        ew.where("state = {0}","1");
        JSONObject object = new JSONObject();
        JSONArray jsonArray = new JSONArray();
        List<User> userList = userMapper.selectPage(page,ew);
        for (User userInfo : userList) {
            JSONObject jsonObject = new JSONObject();
            jsonObject.put("username", userInfo.getUsername());
            jsonObject.put("name", userInfo.getName());
            jsonObject.put("uid", userInfo.getId());
            jsonObject.put("phone", userInfo.getPhone());
            jsonObject.put("state", userInfo.getState());
            jsonObject.put("image", userInfo.getImage());
            jsonArray.add(jsonObject);
        }
        object.put("data", jsonArray);
        return object;
    }


    public boolean deleteById(Long uid) {
        User userInfo = userMapper.selectById(uid);
        if (userInfo == null)
            return false;
        userInfo.setState("0");
        userMapper.updateById(userInfo);
        return true;
    }


}
