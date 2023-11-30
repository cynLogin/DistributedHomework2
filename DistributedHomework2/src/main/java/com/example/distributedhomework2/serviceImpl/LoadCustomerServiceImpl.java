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
}
