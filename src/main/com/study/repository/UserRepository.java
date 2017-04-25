package com.study.repository;

import com.study.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by Administrator on 2017/4/25.
 */
public interface UserRepository extends JpaRepository<User,Integer>{
}
