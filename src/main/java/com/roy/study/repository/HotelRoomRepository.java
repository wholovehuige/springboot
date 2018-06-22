package com.roy.study.repository;

import com.roy.study.domain.HotelRoom;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by roy on 2018/5/26.
 */
public interface HotelRoomRepository extends JpaRepository<HotelRoom,Long> {

    Page<HotelRoom> findAllByCustomerNameContainsOrCustomerPhone(Pageable pageable,String searchName);
}
