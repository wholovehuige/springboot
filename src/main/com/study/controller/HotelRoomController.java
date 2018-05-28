package com.study.controller;

import com.alibaba.fastjson.JSONObject;
import com.study.domain.HotelRoom;
import com.study.service.impl.HotelRoomServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * Created by roy on 2018/5/26.
 */
@Controller
@RequestMapping(value = "/room")
public class HotelRoomController {
    @Autowired
    private HotelRoomServiceImpl hotelRoomService;


    @RequestMapping(value = "/add")
    @ResponseBody
    public Long addRoom(String roomCode,String roomName,String customerPhone,String customerName) {
        Long id = hotelRoomService.addRoom(roomName,roomCode,customerPhone,customerName);
        return id;
    }

    @RequestMapping(value = "/list")
    @ResponseBody
    public List<HotelRoom> roomList(int page,int size) {
        Pageable pageable = new PageRequest(page,size, Sort.Direction.DESC,"id");
        return hotelRoomService.selectAll(pageable);
    }

    @RequestMapping(value = "/count")
    @ResponseBody
    public long getRoomCount() {
        return hotelRoomService.getAllRooms();
    }


    @RequestMapping(value = "/delete")
    public String deleteRoom() {

        return "";
    }

    @RequestMapping(value = "/charts")
    @ResponseBody
    public JSONObject getRoomCharts() {
        JSONObject jsonObject = hotelRoomService.getRoomCharts();
        return jsonObject;
    }


}