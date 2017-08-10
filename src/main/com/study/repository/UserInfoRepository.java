package com.study.repository;

import com.study.domain.user.UserInfo;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * Created by Administrator on 2017/4/25.
 */
public interface UserInfoRepository extends JpaRepository<UserInfo,Long>{
    public UserInfo findByUsername(String userName);

    UserInfo findByUid(Long uid);

}
