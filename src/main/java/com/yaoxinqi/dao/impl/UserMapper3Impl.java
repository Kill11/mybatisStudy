package com.yaoxinqi.dao.impl;

import com.yaoxinqi.dao.UserMapper3;
import com.yaoxinqi.domain.User;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import java.lang.reflect.ParameterizedType;
import java.util.List;

public class UserMapper3Impl implements UserMapper3{

    private SqlSessionFactory factory;

    public UserMapper3Impl(SqlSessionFactory factory){
        this.factory = factory;
    }

    public List<User> findAll() {
        SqlSession session = factory.openSession();
        List<User> users = session.selectList("com.yaoxinqi.dao.UserMapper3.findAll");
        session.close();
        return users;
    }
}
