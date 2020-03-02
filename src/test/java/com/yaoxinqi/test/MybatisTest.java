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

import java.beans.PropertyDescriptor;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Method;
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

    /*
    看下内省类是怎么获得set、get方法的
    因为mybatis查完之后只知道数据库的字段名
    所以是用数据库的字段名来获得PropertyDescriptor的
    这就说明了为什么对象的属性名必须和数据库字段名一致
     */
    @Test
    public void test4() throws Exception{
        User user = new User();
        PropertyDescriptor pd = new PropertyDescriptor("id",User.class);
        System.out.println(pd.getWriteMethod());
        Method writeMethod = pd.getWriteMethod();//用来写的，执行时告诉他往哪个对象的id写，写什么
        Method readMethod = pd.getReadMethod();//用来读的，执行时告诉他读哪个对象的id
        //把获取的列的值，给对象赋值
        writeMethod.invoke(user,123);
        System.out.println("直接获取到的："+user.getId());
        System.out.println("获取到的get方法读到的："+readMethod.invoke(user));
    }
}
