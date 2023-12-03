package com.example.distributedhomework2.mapper;

import com.example.distributedhomework2.bean.StaffBean;

public interface StaffMapper {
    StaffBean getOneById(String id);
    int updateStaff(String id,String usename,String sex,String phoneNumber);
    int deleteStaff(String id);
}
