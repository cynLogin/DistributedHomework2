package com.example.distributedhomework2.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ViewController {
    @RequestMapping("/admin/home/{ID}")
    public String adminHome(){
        return "/admin/admin-home";
    }
    @RequestMapping("/customerDetail/{ID}")
    public String customerDetail(){
        return "/customer/customer-detail";
    }
    @RequestMapping("/customerModify/{ID}")
    public String customerControl(){
        return "/customer/customer-control";
    }
    @RequestMapping("/employee/home/{ID}")
    public String employee(){
        return "/employee/employee-home";
    }
    @RequestMapping("/employeeinfo/{emplyeeID}")
    public String employeeInfo(){
        return "/employee/employee-control";
    }
    @RequestMapping("/admin/employeecontrol/{employeeID}")
    public String employeeManagement(){
        return "/employee/employee-management";
    }
    @RequestMapping("/orderDetail/{ID}")
    public String orderDetail(){
        return "/order/order-detail";
    }
    @RequestMapping("/employee/addorder/{employeeID}")
    public String addOrder(){
        return "/order/order-add";
    }
    @RequestMapping("/admin/productcontrol")
    public String productManagement(){
        return "/product/product-management";
    }
    @RequestMapping("/admin/productModify/{ID}")
    public String productModify(){
        return "/product/product-control";
    }
}
