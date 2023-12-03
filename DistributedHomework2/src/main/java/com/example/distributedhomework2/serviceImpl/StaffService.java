package com.example.distributedhomework2.serviceImpl;

import com.example.distributedhomework2.bean.StaffBean;
import com.example.distributedhomework2.mapper.StaffMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class StaffService {
    @Resource
    StaffMapper staffMapper;
    public StaffBean getStaffInfo(String id){
        return staffMapper.getOneById(id);
    }
    public String changeStaff(String id,String username,String sex,String phoneNumber){
        int item=staffMapper.updateStaff(id,username,sex,phoneNumber);
        if(item>0){
            return "success";
        }
        else{
            return "error";
        }
    }
    public String deleteStaff(String id){
        int item=staffMapper.deleteStaff(id);
        if(item>0){
            return "success";
        }
        else{
            return "error";
        }
    }
}
