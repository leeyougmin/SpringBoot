package com.example.dao;

import org.apache.ibatis.annotations.Mapper;

import com.example.entity.UserInfo;

@Mapper
public interface UserMapper {

    UserInfo getUserById(String username);

}
