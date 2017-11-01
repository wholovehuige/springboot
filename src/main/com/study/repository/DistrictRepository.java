package com.study.repository;

import com.study.domain.District;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by roy on 2017/10/26.
 */
public interface DistrictRepository extends JpaRepository<District,Long> {
}
