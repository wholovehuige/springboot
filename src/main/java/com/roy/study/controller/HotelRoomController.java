package com.roy.tools.controller;

import com.alibaba.fastjson.JSONObject;
import com.roy.tools.model.HotelRoom;
import com.roy.tools.service.HotelRoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.math.BigInteger;
import java.util.List;

/**
 * Created by roy on 2018/5/26.
 */
@Controller
@RequestMapping(value = "/room")
public class HotelRoomController {
    @Autowired
    private HotelRoomService hotelRoomService;


    @RequestMapping(value = "/add")
    @ResponseBody
    public BigInteger addRoom(String roomCode, String roomName, String customerPhone, String customerName) {
        hotelRoomService.addRoom(roomName,roomCode,customerPhone,customerName);
        return new BigInteger("1");
    }

    @RequestMapping(value = "/list")
    @ResponseBody
    public List<HotelRoom> roomList(int page, int size) {
        return hotelRoomService.selectAll(page,size);
    }

    @RequestMapping(value = "/list/by")
    @ResponseBody
    public List<HotelRoom> roomListBy(String searchName) {
        return hotelRoomService.roomListBy(searchName);
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
