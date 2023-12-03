package com.example.distributedhomework2.mapper;

import com.example.distributedhomework2.bean.CustomerBean;
import org.apache.ibatis.annotations.Mapper;

public interface CustomerMapper {
    CustomerBean getById(String id);
    CustomerBean getByNamePhone(String name,String phoneNumber,String id);
    int change(String id,String phoneNumber,String username,String sex,double totalConsumption,String address);
    int deleteOne(String id);
}
