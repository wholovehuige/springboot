package com.study;

import com.study.properties.QuNiuService;
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

    @Test
    public void qiniu() {
        String token = quNiuService.getQiNiuToken();
        System.out.println("qiNiu== "+token);

    }
}
