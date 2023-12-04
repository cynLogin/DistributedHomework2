package com.example.distributedhomework2.serviceImpl;

import com.example.distributedhomework2.bean.OrdersBean;
import com.example.distributedhomework2.mapper.OrdersMapper;
import com.example.distributedhomework2.mapper.OrdersProductMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

@Service
public class OrdersService {
    @Resource
    OrdersMapper ordersMapper;
    @Resource
    OrdersProductMapper ordersProductMapper;
    public OrdersBean getById(String id){
        return ordersMapper.getById(id);
    }
    public List<OrdersBean> getAllByCustomerId(String id){
        return ordersMapper.getAllByCustomerId(id);
    }
    public String changeStatus(String id,String completionStatus){
        int changes=ordersMapper.changeStatus(id,completionStatus);
        if(changes>0){
            return "success";
        }
        else{
            return "error";
        }
    }
    public String deleteOrder(String id){
        int changes=ordersMapper.deleteOrder(id);
        if(changes>0){
            return "success";
        }
        else{
            return "error";
        }
    }
    public List<OrdersBean> getAll(){
        return ordersMapper.getAll();
    }
    public String addOrder(double totalPrice, String customerName, String orderRemark, List<Map<String,String>>orderContent)
    {
        int item1=ordersMapper.addOneOrder(totalPrice,customerName,orderRemark);
        String newId=ordersMapper.getNew();
        for (Map<String, String> order : orderContent) {
            for (Map.Entry<String, String> entry : order.entrySet()) {
                String key = entry.getKey();
                String value = entry.getValue();
                ordersProductMapper.insertData(newId,key,value);
            }
        }
        if(item1>0) return "success";
        else return "error";

    }
}
