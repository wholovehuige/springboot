package com.roy.tools.mapper;

import com.roy.tools.model.HotelRoom;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by roy on 2018/6/23.
 */
@Mapper
@Component
public interface HotelRoomMapper extends SupperMapper<HotelRoom> {

    Long selectCount();

    List<HashMap> selectRoomNameAndCount();
}
