package com.yaoxinqi.dao;

import com.yaoxinqi.domain.User;
import org.apache.ibatis.annotations.Many;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

import java.util.List;

//注解方式
public interface UserMapper2 {

    @Select("select * from user;")
    @Results(id="userMap",value = {
            @Result(id = true,column = "id",property = "userId"),
            @Result(column = "username",property = "userName"),
            @Result(column = "birthday",property = "userBirthday"),
            @Result(column = "sex",property = "userSex"),
            @Result(column = "address",property = "userAddress"),
            @Result(property = "accounts",column = "id",many=@Many(select = "com.yaoxinqi.dao.AccountMapper.findAccountByUserId"))
    })
    List<User> findAll();
}
