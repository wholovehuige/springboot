package com.study.repository;

import com.study.domain.RequestDomain;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by roy on 2017/8/2.
 */
public interface RequestDomainRepository extends JpaRepository<RequestDomain,Long> {

}
