package com.example.distributedhomework2.controller;

import com.example.distributedhomework2.bean.CustomerBean;
import com.example.distributedhomework2.service.LoadCustomerService;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
public class LoadCustomerController {
    @Resource
    LoadCustomerService loadCustomerService;
    @RequestMapping(value = "/employee/getcustomerinfo/{customerID}",method = RequestMethod.GET)
    public CustomerBean load(@PathVariable String customerID){
        return loadCustomerService.load(customerID);
    }
    @RequestMapping(value = "/employee/querycustomer",method = RequestMethod.POST)
    public CustomerBean loadByNamePhone(String customerName,String customerPhone ){
        return loadCustomerService.loadByNamePhone(customerName,customerPhone);
    }
}
