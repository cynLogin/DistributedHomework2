package com.example.distributedhomework2.mapper;

import com.example.distributedhomework2.bean.ProductBean;

import java.util.List;

public interface ProductMapper {
    int addOneProduct(String productId,String productName,double unitPrice);
    List<ProductBean> getAll();
}
