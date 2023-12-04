package com.example.distributedhomework2.controller;

import com.example.distributedhomework2.bean.StaffBean;
import com.example.distributedhomework2.serviceImpl.StaffService;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

@RestController
public class StaffController {
    @Resource
    StaffService staffService;
    @RequestMapping(value = "/getemployeeinfo/{id}",method = RequestMethod.GET)
    public StaffBean getStaffInfo(@PathVariable String id){
        return staffService.getStaffInfo(id);
    }
    @RequestMapping(value = "/modifyemployee",method = RequestMethod.POST)
    public String changeStaff(String id,String newName,String newSex,String newPhone){
        return staffService.changeStaff(id,newName,newSex,newPhone);
    }
    @RequestMapping(value = "/modifyemployee/delete",method = RequestMethod.POST)
    public String deleteStaff(String id){
        return staffService.deleteStaff(id);
    }
    @RequestMapping(value = "/admin/allemployee",method = RequestMethod.POST)
    public List<StaffBean> loadAll(){
        return staffService.getAll();
    }
    @RequestMapping(value = "/admin/queryemployee",method = RequestMethod.POST)
    public List<StaffBean> loadByNamePhone(String username,String phoneNumber){
        return staffService.getByNamePhone(username,phoneNumber);
    }
    @RequestMapping(value = "/admin/addemployee",method = RequestMethod.POST)
    public String addOne(String addName,String addPhone,String addSex){
        return staffService.addOne(addName,addPhone,addSex);
    }
}
