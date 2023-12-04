package com.example.distributedhomework2.controller;

import com.example.distributedhomework2.bean.CustomerBean;
import com.example.distributedhomework2.service.CustomerService;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

@RestController
public class CustomerController {
    @Resource
    CustomerService customerService;
    @RequestMapping(value = "/getcustomerinfo/{customerID}",method = RequestMethod.GET)
    public CustomerBean load(@PathVariable String customerID){
        return customerService.load(customerID);
    }
    @RequestMapping(value = "/employee/querycustomer",method = RequestMethod.POST)
    public List<CustomerBean> loadByNamePhone(String userName, String phoneNumber, String employeeID){
        return customerService.loadByNamePhone(userName,phoneNumber,employeeID);
    }
    @RequestMapping(value = "/modifycustomer",method = RequestMethod.POST)
    public String update(String id,String newName,String newSex,String newPhone,double newConsumption,String newAddress){
        return customerService.update(id,newPhone,newName,newSex,newConsumption,newAddress);
    }
    @RequestMapping(value = "/modifycustomer/delete",method = RequestMethod.POST)
    public String deleteOne(String id){
        return customerService.deleteOne(id);
    }
    @RequestMapping(value = "/employee/getcustomer",method = RequestMethod.POST)
    public List<CustomerBean> getByStaffId(String employeeID){
        return customerService.loadByEmployeeId(employeeID);
    }
    @RequestMapping(value = "/employee/addcustomer",method = RequestMethod.POST)
    public String addOne(String id,String username,String sex,String phoneNumber,String address,String employeeID){
        return customerService.addOne(id,username,phoneNumber,sex,address,employeeID);
    }
}
