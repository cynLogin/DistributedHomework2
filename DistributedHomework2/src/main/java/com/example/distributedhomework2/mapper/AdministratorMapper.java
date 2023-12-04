package com.example.distributedhomework2.mapper;

import com.example.distributedhomework2.bean.AdministratorBean;

public interface AdministratorMapper {
    public AdministratorBean getByName(String username);
}
