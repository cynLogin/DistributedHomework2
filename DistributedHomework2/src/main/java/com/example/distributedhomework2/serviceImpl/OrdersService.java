package com.example.distributedhomework2.serviceImpl;

import com.example.distributedhomework2.bean.OrdersBean;
import com.example.distributedhomework2.mapper.OrdersMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class OrdersService {
    @Resource
    OrdersMapper ordersMapper;
    public OrdersBean getById(String id){
        return ordersMapper.getById(id);
    }
    public List<OrdersBean> getAllByCustomerId(String id){
        return ordersMapper.getAllByCustomerId(id);
    }
    public String addOneOrder(double amountMoney,int completionStatus,String consumerId,String notes){
        int changes=ordersMapper.addOneOrder(amountMoney,completionStatus,consumerId,notes);
        if(changes>0){
            return "success";
        }
        else{
            return "error";
        }
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
}
