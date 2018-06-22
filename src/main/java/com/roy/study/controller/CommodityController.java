package com.roy.study.controller;

import com.roy.study.domain.District;
import com.roy.study.repository.DistrictRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.io.*;

/**
 * Created by roy on 2017/8/16.
 */
@Controller
@RequestMapping(value = "/commodity")
public class CommodityController {

    @Autowired
    private DistrictRepository districtRepository;


    @RequestMapping(value = "/file")
    @ResponseBody
    public String dell() {
        try {
            FileReader reader = new FileReader("C:/temp/subline_dire/districtData");
            BufferedReader bufferedReader = new BufferedReader(reader);
            String str = "";
            String d1 = "";
            String d2 = "";
            String d3 = "";
            String d4 = "";
            while (bufferedReader.readLine() != null) {
                District district = new District();
                str = bufferedReader.readLine();
                System.out.println(str);
                if(str !=null) {
                    String[] strings = str.split(" ");
                    d1 = regex(strings[1]);
                    district.setCode(d1);
                    d2 = regex(strings[2]);
                    district.setName(d2);
                    d3 = regex(strings[3]);
                    district.setPinyin(d3);
                    d4 = regex(strings[4]);
                    district.setProvince(d4);
                    districtRepository.save(district);
                    System.out.println("==========");
                }
            }

        } catch (Exception e) {
            e.printStackTrace();

        }
        return "1";
    }


    public static String regex(String str) {
        str = str.replace("/","");
        str = str.replace(">","");
        StringBuilder builder = new StringBuilder();
        boolean flag = false;
        char[] chars = str.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            if (String.valueOf(chars[i]).equals("\"")) {
                if(flag) {
                    flag = false;
                }
                if(!flag) {
                    flag = true;
                }
            }
            if(flag){
                builder.append(chars[i]);
            }
        }
        return builder.toString();
    }

}
