package com.example.distributedhomework2.mapper;

import com.example.distributedhomework2.bean.StaffBean;

import java.util.List;

public interface StaffMapper {
    StaffBean getOneById(String id);
    int updateStaff(String id,String usename,String sex,String phoneNumber);
    int deleteStaff(String id);
    List<StaffBean> getAll();
    List<StaffBean> getByNamePhone(String username,String phoneNumber);
    int addOne(String username,String phoneNumber,String sex);
}
