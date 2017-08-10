package com.study;

import com.alibaba.fastjson.JSONObject;
import com.study.properties.QuNiuService;
import com.study.service.UserInfoService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * Created by roy on 2017/7/31.
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class MainTest {
    @Autowired
    QuNiuService quNiuService;
    @Autowired
    private UserInfoService userInfoService;

    @Test
    public void qiniu() {
        JSONObject object = userInfoService.getUserDetail();

        System.out.println(object);
    }
}
