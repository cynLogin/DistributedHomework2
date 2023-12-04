package com.example.distributedhomework2.mapper;

import com.example.distributedhomework2.bean.OrdersBean;

import java.util.List;

public interface OrdersMapper {
    OrdersBean getById(String id);
    List<OrdersBean> getAllByCustomerId(String id);
    int addOneOrder(double amountMoney,String consumerName,String notes);
    int changeStatus(String id,String completionStatus);
    int deleteOrder(String orderID);
    List<OrdersBean> getAll();
    String getNew();

}
