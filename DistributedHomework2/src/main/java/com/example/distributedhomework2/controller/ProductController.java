package com.example.distributedhomework2.controller;

import com.example.distributedhomework2.bean.ProductBean;
import com.example.distributedhomework2.serviceImpl.ProductService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

@RestController
public class ProductController {
    @Resource
    ProductService productService;
    @RequestMapping(value = "/employee/addnewproduct",method = RequestMethod.POST)
    public String addOneProduct(String productID,String productName,double unitPrice){
        return productService.addOneProduct(productID,productName,unitPrice);
    }
    @RequestMapping(value = "/employee/allProduct",method = RequestMethod.GET)
    public List<ProductBean> getAll(){
        return productService.getAll();
    }
    @RequestMapping(value = "/queryProduct",method = RequestMethod.GET)
    public List<ProductBean> getByName(String name){
        return productService.getByName(name);
    }
}
