package com.example.distributedhomework2.controller;

import com.example.distributedhomework2.bean.ProductBean;
import com.example.distributedhomework2.serviceImpl.ProductService;
import org.apache.tomcat.util.json.JSONParser;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

@RestController
public class ProductController {
    @Resource
    ProductService productService;
    @RequestMapping(value = "/employee/addnewproduct",method = RequestMethod.POST)
    public String addOneProduct(@RequestBody Map<String, String> request){
        String productID=request.get("productID");
        String productName=request.get("productName");
        String unitPrice=request.get("unitPrice");
        //将unitPrice转换为double
        double unitPriceDouble=Double.parseDouble(unitPrice);
        return productService.addOneProduct(productID,productName,unitPriceDouble);
    }
    @RequestMapping(value = "/allProduct",method = RequestMethod.GET)
    public List<ProductBean> getAll(){
        return productService.getAll();
    }
    @RequestMapping(value = "/queryProduct",method = RequestMethod.POST)
    public List<ProductBean> getByName(String name){
        return productService.getByName(name);
    }
    @RequestMapping(value = "/admin/modifyproduct",method = RequestMethod.POST)
    public String updateOne(String id,String name,double price,int inventory){
        return productService.update(id,name,price,inventory);
    }
    @RequestMapping(value = "/admin/getproduct",method = RequestMethod.POST)
    public ProductBean getOneById(String id){
        System.out.println(id);
        return productService.getOneById(id);
    }
    @RequestMapping(value = "/admin/deleteproduct",method = RequestMethod.POST)
    public String deleteOne(String id){

        return productService.delete(id);
    }
    @RequestMapping(value = "/admin/addproduct",method = RequestMethod.POST)
    public String addOne(String id,String productName,double unitPrice){
        return productService.addOne(id,productName,unitPrice);
    }
}
