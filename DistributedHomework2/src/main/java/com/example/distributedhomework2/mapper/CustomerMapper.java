package com.example.distributedhomework2.mapper;

import com.example.distributedhomework2.bean.CustomerBean;
import org.apache.ibatis.annotations.Mapper;

public interface CustomerMapper {
    CustomerBean getById(String id);
}
