package com.roy.study.repository;

import com.roy.study.domain.Commodity;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by roy on 2017/8/16.
 */
public interface CommodityRepository extends JpaRepository<Commodity,Long> {
}
