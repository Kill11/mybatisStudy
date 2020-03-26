package com.yaoxinqi.dao;

import com.yaoxinqi.domain.QuaryVo;
import com.yaoxinqi.domain.User;

//xml方式
import java.util.List;

public interface UserMapper {

    List<User> findAll();

    void saveUser(User user);

    void updateUser(User user);

    void deleteUser(Integer userId);

    User findById(Integer userId);

    List<User> findByName(String username);

    int findTotal();

    List<User> findByQuaryVo(QuaryVo quaryVo);

    List<User> findByInIds(QuaryVo quaryVo);
}
