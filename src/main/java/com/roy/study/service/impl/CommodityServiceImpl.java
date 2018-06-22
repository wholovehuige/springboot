package com.roy.study.service.impl;

import com.roy.study.domain.Commodity;
import com.roy.study.repository.CommodityRepository;
import com.roy.study.service.CommodityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

/**
 * Created by roy on 2017/8/16.
 */
@Service
public class CommodityServiceImpl implements CommodityService {
    @Autowired
    private CommodityRepository commodityRepository;

    @Override
    public void initCommodity(String userId ,String name, String desc, String image, String company) {
        Commodity commodity = new Commodity();
        commodity.setGoodsName(name);
        commodity.setDescription(desc);
        commodity.setImage(image);
        commodity.setCompany(company);
        commodity.setCrDate(new Date());
        commodity.setUpDate(new Date());
        commodity.setCreatedBy(userId);
        commodityRepository.save(commodity);
    }
}
