package com.example.distributedhomework2.serviceImpl;

import com.example.distributedhomework2.bean.OrdersBean;
import com.example.distributedhomework2.mapper.OrdersMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class OrdersService {
    @Resource
    OrdersMapper ordersMapper;
    public OrdersBean getById(String id){
        return ordersMapper.getById(id);
    }
}
