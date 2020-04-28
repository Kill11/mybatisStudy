package com.yaoxinqi.test;

import com.yaoxinqi.dao.UserMapper;
import com.yaoxinqi.dao.UserMapper2;
import com.yaoxinqi.dao.UserMapper3;
import com.yaoxinqi.dao.UserRoleMapper;
import com.yaoxinqi.dao.impl.UserMapper3Impl;
import com.yaoxinqi.domain.QuaryVo;
import com.yaoxinqi.domain.Role;
import com.yaoxinqi.domain.User;
import com.yaoxinqi.domain.UserRole;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class UserRoleTest {
    InputStream in;
    SqlSession session;
    UserRoleMapper userRoleMapper;

    @BeforeMethod
    public void init() throws IOException{
        //读取配置
        in = Resources.getResourceAsStream("SqlMapConfig.xml");
        //创建session工厂
        SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();
        SqlSessionFactory factory = builder.build(in);
        session = factory.openSession();
    }

    @Test
    public void testFindAllRole(){
        //动态代理，给出代理类
        userRoleMapper = session.getMapper(UserRoleMapper.class);
        List<Role> roles = userRoleMapper.findAllRole();
        for(Role role:roles){
            System.out.println(role);
        }
    }

    @Test
    public void testFindAllUser(){
        //动态代理，给出代理类
        userRoleMapper = session.getMapper(UserRoleMapper.class);
        List<UserRole> userRoles = userRoleMapper.findAllUser();
        for(UserRole userRole:userRoles){
            System.out.println(userRole);
        }
    }

    @AfterMethod
    public void destroy() throws IOException{
        session.commit();
        session.close();
        in.close();
    }
}
