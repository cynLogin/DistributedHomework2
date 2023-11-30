package com.example.distributedhomework2.controller;

import com.example.distributedhomework2.bean.OrdersBean;
import com.example.distributedhomework2.mapper.OrdersMapper;
import com.example.distributedhomework2.serviceImpl.OrdersService;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
public class OrdersController {
    @Resource
    OrdersService ordersService;
    @RequestMapping(value = "/employee/orderDetail/{orderID}",method = RequestMethod.GET)
    public OrdersBean loadById(@PathVariable String orderID){
        return ordersService.getById(orderID);
    }
}
