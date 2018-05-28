package com.study.repository;

import com.study.domain.HotelRoom;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by roy on 2018/5/26.
 */
public interface HotelRoomRepository extends JpaRepository<HotelRoom,Long> {
}
