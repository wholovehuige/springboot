package com.roy.tools.mapper;

import com.roy.tools.model.User;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

import java.util.HashMap;

/**
 * Created by roy on 2018/6/23.
 */
@Mapper
@Component
public interface UserMapper extends SupperMapper<User> {


    HashMap findByPhone(String phone);

}
