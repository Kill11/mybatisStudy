package com.yaoxinqi.dao;

import com.yaoxinqi.domain.User;
import org.apache.ibatis.annotations.Select;

//xml方式
import java.util.List;

public interface UserMapper {

    List<User> findAll();
}
