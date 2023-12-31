package com.example.distributedhomework2.mapper;

import com.example.distributedhomework2.bean.StaffBean;

import java.util.List;

public interface StaffMapper {
    StaffBean getOneById(String id);
    int updateStaff(String id,String username,String sex,String phoneNumber);
    int deleteStaff(String id);
    List<StaffBean> getAll();
    List<StaffBean> getByNamePhone(String username,String phoneNumber);
    int addOne(String id,String username,String phoneNumber,String sex);
    int updatePwd(String id,String password,String newPassword);
    StaffBean getByName(String username);
}
