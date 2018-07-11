package com.roy.tools.config;

import com.baomidou.mybatisplus.mapper.MetaObjectHandler;
//import lombok.extern.slf4j.Slf4j;
//import org.apache.commons.lang3.StringUtils;
import org.apache.ibatis.reflection.MetaObject;

import java.sql.Timestamp;

/**
 * Created with IntelliJ IDEA.
 *
 * @author: chenzhongyong@cecdat.com
 * Date: 2018/6/21
 * Time: 17:13
 */
//@Slf4j
public class FieldFillHandler extends MetaObjectHandler {

    @Override
    public void insertFill(MetaObject metaObject) {

//        log.info("%s%s%s",StringUtils.repeat("*",10),"inserFill",StringUtils.repeat("*",10));
        // 测试下划线 mybatis-plus版本2.0.9+
        Object crDate = getFieldValByName("crDate", metaObject);
        if (crDate == null) {
            setFieldValByName("crDate", new Timestamp(System.currentTimeMillis()), metaObject);
        }

        Object status = getFieldValByName("status", metaObject);
        if (status == null) {
            setFieldValByName("status", 1, metaObject);
        }
    }

    @Override
    public void updateFill(MetaObject metaObject) {
        //更新填充
//        log.info("%s%s%s",StringUtils.repeat("*",10),"updateFill",StringUtils.repeat("*",10));
        //mybatis-plus版本2.0.9+
        setFieldValByName("upDate", new Timestamp(System.currentTimeMillis()), metaObject);
    }
}
