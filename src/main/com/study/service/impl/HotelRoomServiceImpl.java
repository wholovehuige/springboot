package com.study.service.impl;


import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.study.domain.HotelRoom;
import com.study.repository.HotelRoomRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by roy on 2018/5/26.
 */
@Service
public class HotelRoomServiceImpl {

    @Autowired
    private HotelRoomRepository hotelRoomRepository;
    @Autowired
    private EntityManager entityManager;


    public BigInteger addRoom(String roomName, String roomCode, String customerPhone, String customerName) {
        HotelRoom room = new HotelRoom();
        room.setRoomName(roomName);
        room.setRoomCode(roomCode);
        room.setCustomerName(customerName);
        room.setCustomerPhone(customerPhone);
        room.setStatus("1");
        room.setCreatedDate(new Date());
        room = hotelRoomRepository.saveAndFlush(room);
        return room.getId();
    }

    public boolean deleteRoom(Long id) {
        HotelRoom room = hotelRoomRepository.findOne(id);
        if (room == null) {
            return false;
        }
        hotelRoomRepository.delete(id);
        return true;
    }

    public List<HotelRoom> selectAll(Pageable pageable) {
        Sort sortx = new Sort(new Sort.Order(Sort.Direction.DESC, "id"));
        Page<HotelRoom> roomPageable = hotelRoomRepository.findAll(pageable);
        return roomPageable.getContent();
    }

    public Long getAllRooms() {
        return hotelRoomRepository.count();
    }

    public List<HotelRoom> roomListBy(String searchName) {
        List<HotelRoom> arrr = new ArrayList<>();
        String sql = "select id,customer_name,customer_phone,room_code,room_name,created_date,status from hotel_room where customer_phone like '%" + searchName + "%' or customer_name like '%" + searchName + "%'";
        Query oneQuery = entityManager.createNativeQuery(sql);
        List list = oneQuery.getResultList();
        for (int i = 0; i < list.size(); i++) {
            Object[] o = (Object[]) list.get(i);
            HotelRoom hotelRoom = new HotelRoom();
            hotelRoom.setId((BigInteger) o[0]);
            hotelRoom.setCustomerName((String) o[1]);
            hotelRoom.setCustomerPhone((String) o[2]);
            hotelRoom.setRoomCode((String) o[3]);
            hotelRoom.setRoomName((String) o[4]);
            hotelRoom.setCreatedDate((Date) o[5]);
            hotelRoom.setStatus((String) o[6]);
            arrr.add(hotelRoom);
        }
        return arrr;
    }


    public JSONObject getRoomCharts() {
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("Etext", "所有客房统计");
        jsonObject.put("Esubtext", "客房类型");
        String sql = "SELECT room_name,count(id) as conm  FROM hotel_room  GROUP BY room_code";
        Query oneQuery = entityManager.createNativeQuery(sql);
        List list = oneQuery.getResultList();
        JSONArray titleData = new JSONArray();
        titleData.add("标间");
        titleData.add("大床房");
        titleData.add("商务房间");
        titleData.add("圆床房间");
        titleData.add("总统套间");
        JSONArray dataData = new JSONArray();
        for (int i = 0; i < list.size(); i++) {
            JSONObject ob = new JSONObject();
            Object[] object = (Object[]) list.get(i);
            String roomName = (String) object[0];
            BigInteger roomCoom = (BigInteger) object[1];
            ob.put("name", roomName);
            ob.put("value", roomCoom);
            dataData.add(ob);
        }
        jsonObject.put("titleData", titleData);
        jsonObject.put("dataData", dataData);
        return jsonObject;
    }

}
