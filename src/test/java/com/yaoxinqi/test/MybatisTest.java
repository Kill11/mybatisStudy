package com.yaoxinqi.test;

import com.yaoxinqi.dao.UserMapper;
import com.yaoxinqi.dao.UserMapper2;
import com.yaoxinqi.dao.UserMapper3;
import com.yaoxinqi.dao.impl.UserMapper3Impl;
import com.yaoxinqi.domain.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.testng.annotations.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class MybatisTest {
    @Test
    public void test1() throws IOException {
        //读取配置
        InputStream in = Resources.getResourceAsStream("SqlMapConfig.xml");
        //创建session工厂
        SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();
        SqlSessionFactory factory = builder.build(in);
        SqlSession session = factory.openSession();
        //动态代理，给出代理类
        UserMapper userMapper = session.getMapper(UserMapper.class);
        List<User> users = userMapper.findAll();
        for(User user:users){
            System.out.println(user);
        }
        session.close();
        in.close();
    }

    @Test
    public void test2() throws IOException {
        //读取配置
        InputStream in = Resources.getResourceAsStream("SqlMapConfig.xml");
        //创建session工厂
        SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();
        SqlSessionFactory factory = builder.build(in);
        SqlSession session = factory.openSession();
        //动态代理，给出代理类
        UserMapper2 userMapper2 = session.getMapper(UserMapper2.class);
        List<User> users = userMapper2.findAll();
        for(User user:users){
            System.out.println(user);
        }
        session.close();
        in.close();
    }

    @Test
    public void test3() throws IOException {
        //读取配置
        InputStream in = Resources.getResourceAsStream("SqlMapConfig.xml");
        //创建session工厂
        SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();
        SqlSessionFactory factory = builder.build(in);
        UserMapper3 userMapper3 = new UserMapper3Impl(factory);
        List<User> users = userMapper3.findAll();
        for(User user:users){
            System.out.println(user);
        }
        in.close();
    }
}
