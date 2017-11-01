package com.study.repository;

import com.study.domain.user.Login;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by Administrator on 2017/5/4.
 */
public interface LoginRepository extends JpaRepository<Login,Long> {
    Login findByPhone(String phone);
}
