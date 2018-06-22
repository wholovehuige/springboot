package com.roy.study.service;

import org.springframework.stereotype.Service;

/**
 * Created by roy on 2017/8/16.
 */
@Service
public interface CommodityService {

    void initCommodity(String userId,String name,String desc,String image,String company);


}
