package com.example.distributedhomework2.serviceImpl;

import com.example.distributedhomework2.bean.ProductBean;
import com.example.distributedhomework2.mapper.ProductMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class ProductService {
    @Resource
    ProductMapper productMapper;
    public String addOneProduct(String productId,String productName,double unitPrice){
        int changes=productMapper.addOneProduct(productId,productName,unitPrice);
        if(changes>0){
            return "success";
        }
        else{
            return "error";
        }
    }
    public List<ProductBean> getAll(){
        return productMapper.getAll();
    }
    public List<ProductBean> getByName(String productName){
        return productMapper.getByName(productName);
    }
}
