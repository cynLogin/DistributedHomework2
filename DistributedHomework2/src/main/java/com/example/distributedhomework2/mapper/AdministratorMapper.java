package com.example.distributedhomework2.mapper;

import com.example.distributedhomework2.bean.AdministratorBean;

public interface AdministratorMapper {
    AdministratorBean getById(String id);
    AdministratorBean getByName(String username);
}
