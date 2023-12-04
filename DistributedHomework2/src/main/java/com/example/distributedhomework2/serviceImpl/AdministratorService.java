package com.example.distributedhomework2.serviceImpl;

import com.example.distributedhomework2.bean.AdministratorBean;
import com.example.distributedhomework2.mapper.AdministratorMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class AdministratorService {
    @Resource
    AdministratorMapper administratorMapper;
    AdministratorBean getByName(String username){
        return administratorMapper.getByName(username);
    }
}
