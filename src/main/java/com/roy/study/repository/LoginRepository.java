package com.roy.study.repository;

import com.roy.study.domain.user.Login;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

/**
 * Created by Administrator on 2017/5/4.
 */
public interface LoginRepository extends JpaRepository<Login,Long> {
    Login findByPhone(String phone);
}
