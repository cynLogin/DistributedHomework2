package com.example.distributedhomework2.serviceImpl;

import com.example.distributedhomework2.bean.CustomerBean;
import com.example.distributedhomework2.mapper.CustomerMapper;
import com.example.distributedhomework2.service.LoadCustomerService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
@Service
public class LoadCustomerServiceImpl implements LoadCustomerService {
    @Resource
    CustomerMapper customerMapper;
    public CustomerBean load(String id){
        return customerMapper.getById(id);
    }
    public CustomerBean loadByNamePhone(String name,String phoneNumber){
        return customerMapper.getByNamePhone(name,phoneNumber);
    }
    public String update(String id,String phoneNumber,String username,String sex,double totalConsumption,String address){
        int item=customerMapper.change(id,phoneNumber,username,sex,totalConsumption,address);
        if(item>0) return "success";
        else return "error";
    }
    public String deleteOne(String id){
        int item=customerMapper.deleteOne(id);
        if(item>0) return "success";
        else return "error";
    }
}
