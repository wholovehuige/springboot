package com.study.repository;

import com.study.domain.user.UserInfo;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by Administrator on 2017/4/25.
 */
public interface UserInfoRepository extends JpaRepository<UserInfo,Long>{
    public UserInfo findByUsername(String userName);

    UserInfo findByUid(Long uid);
}
