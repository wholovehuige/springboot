package com.roy.tools.service;


import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.roy.tools.mapper.HotelRoomMapper;
import com.roy.tools.model.HotelRoom;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by roy on 2018/5/26.
 */
@Service
public class HotelRoomService {

    @Autowired
    private HotelRoomMapper hotelRoomMapper;


    public void addRoom(String roomName, String roomCode, String customerPhone, String customerName) {
        HotelRoom room = new HotelRoom();
        room.setRoomName(roomName);
        room.setRoomCode(roomCode);
        room.setCustomerName(customerName);
        room.setCustomerPhone(customerPhone);
        room.setStatus("1");
        room.setCrDate(new Date());
        hotelRoomMapper.insert(room);
    }

    public boolean deleteRoom(Long id) {

        HotelRoom room = hotelRoomMapper.selectById(id);
        if (room == null) {
            return false;
        }
        hotelRoomMapper.deleteById(id);
        return true;
    }

    public List<HotelRoom> selectAll(int pageNumber,int pageSize) {
        Page<HotelRoom> page = new Page<>(pageNumber, pageSize);
        Wrapper<HotelRoom> ew = new EntityWrapper<>();
        ew = ew.orderBy("id","asc".equals("asc"));

//        ew.like("name","");

        return hotelRoomMapper.selectPage(page,ew);
    }

    public Long getAllRooms() {
        return hotelRoomMapper.selectCount();
    }

    public List<HotelRoom> roomListBy(String searchName) {
        EntityWrapper<HotelRoom> ew = new EntityWrapper<HotelRoom>();
        ew.like("customer_phone",searchName);
        return hotelRoomMapper.selectList(ew);
    }


    public JSONObject getRoomCharts() {
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("Etext", "所有客房统计");
        jsonObject.put("Esubtext", "客房类型");
        JSONArray titleData = new JSONArray();
        titleData.add("标间");
        titleData.add("大床房");
        titleData.add("商务房间");
        titleData.add("圆床房间");
        titleData.add("总统套间");
        JSONArray dataData = new JSONArray();
        List<HashMap> mapList = hotelRoomMapper.selectRoomNameAndCount();
        if(mapList.size()> 0) {
            for(HashMap map: mapList){
                JSONObject ob = new JSONObject();
                ob.put("name", map.get("room_name"));
                ob.put("value",  map.get("conm"));
                dataData.add(ob);
            }
        }
        jsonObject.put("titleData", titleData);
        jsonObject.put("dataData", dataData);
        return jsonObject;
    }

}
