package com.example.dao;

import org.apache.ibatis.annotations.Mapper;

import com.example.entity.UserInfo;

@Mapper
public interface CommonMapper {

    void setLogInAccesLog(UserInfo userInfo) throws Exception;

}
