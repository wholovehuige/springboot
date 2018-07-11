package com.roy.tools.service;

import com.qiniu.util.Auth;
import com.roy.tools.constant.Constant;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.util.Date;


/**
 * Created by roy on 2017/7/28.
 */
@Service
public class QuNiuService {

    /**
     * 获取七牛token
     * @return
     */
    public String getQiNiuToken() {
        Auth auth = Auth.create(Constant.QiNiu_Access_Key, Constant.QiNiu_Secret_Key);
        return auth.uploadToken(Constant.buket);
    }

    @Scheduled(fixedRate = 60)
    public void timerTask() {
        System.out.println("定时任务执行" + new Date());
    }

}
