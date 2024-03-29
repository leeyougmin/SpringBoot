package com.example.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.dao.CommonMapper;
import com.example.entity.UserInfo;

@Service
public class CommonSerivce {

    protected final Logger log = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private CommonMapper commonMapper;

    public void setLogInAccesLog(UserInfo userInfo) throws Exception {
        commonMapper.setLogInAccesLog(userInfo);
    }

}
