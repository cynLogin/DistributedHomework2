package com.example.distributedhomework2.controller;

import com.example.distributedhomework2.bean.OrdersBean;
import com.example.distributedhomework2.mapper.OrdersMapper;
import com.example.distributedhomework2.serviceImpl.OrdersService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.swing.plaf.PanelUI;
import java.util.List;
import java.util.Map;

@RestController
public class OrdersController {
    @Resource
    OrdersService ordersService;
    @RequestMapping(value = "/getorderinfo/{orderID}",method = RequestMethod.GET)
    public OrdersBean loadById(@PathVariable String orderID){
        return ordersService.getById(orderID);
    }
    @RequestMapping(value = "/employee/order/bycustomerid/{customerID}",method = RequestMethod.GET)
    public List<OrdersBean> loadByCustomerId(@PathVariable String customerID){
        return ordersService.getAllByCustomerId(customerID);
    }
    @RequestMapping(value = "/addOrder",method = RequestMethod.POST)
    public String addOneOrder(double totalPrice, String customerName, String orderRemark, List<Map<String,String>>orderContent){
        return ordersService.addOrder(totalPrice,customerName,orderRemark,orderContent);
    }
    @RequestMapping(value = "/updateorderstatus",method = RequestMethod.POST)
    public String changeStatus(String orderID,String status){
        return ordersService.changeStatus(orderID,status);
    }
    @RequestMapping(value = "/deleteorder",method = RequestMethod.POST)
    public String deleteOrder(String orderID){
        return ordersService.deleteOrder(orderID);
    }
    @GetMapping(value = "/admin/order/all")
    public List<OrdersBean> getAll(){
        return ordersService.getAll();
    }
}
