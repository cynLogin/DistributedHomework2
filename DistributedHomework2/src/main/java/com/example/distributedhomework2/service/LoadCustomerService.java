package com.example.distributedhomework2.service;

import com.example.distributedhomework2.bean.CustomerBean;

public interface LoadCustomerService {
    CustomerBean load(String id);
    CustomerBean loadByNamePhone(String name,String phoneNumber);
}
