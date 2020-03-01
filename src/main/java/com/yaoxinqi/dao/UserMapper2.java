package com.yaoxinqi.dao;

import com.yaoxinqi.domain.User;
import org.apache.ibatis.annotations.Select;

import java.util.List;

//注解方式
public interface UserMapper2 {

    @Select("select * from user;")
    List<User> findAll();
}
