package com.yaoxinqi.test;

import com.yaoxinqi.dao.UserMapper;
import com.yaoxinqi.domain.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class MybatisTest {
    public static void main(String[] args) throws IOException {
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
}
