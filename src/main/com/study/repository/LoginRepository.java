package com.study.repository;

import com.study.domain.Login;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

/**
 * Created by Administrator on 2017/5/4.
 */
public interface LoginRepository extends JpaRepository<Login,Integer> {
    Login findByPhone(String phone);
}
