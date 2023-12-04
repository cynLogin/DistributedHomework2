package com.example.distributedhomework2.mapper;

import com.example.distributedhomework2.bean.OrdersBean;

import java.util.List;

public interface OrdersMapper {
    OrdersBean getById(String id);
    List<OrdersBean> getAllByCustomerId(String id);
    int addOneOrder(double amountMoney,int completionStatus,String consumerId,String notes);
    int changeStatus(String id,String completionStatus);
}
