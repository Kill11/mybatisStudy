package com.yaoxinqi.test;

import com.sun.xml.internal.ws.policy.privateutil.PolicyUtils;
import com.yaoxinqi.dao.UserMapper;
import com.yaoxinqi.dao.UserMapper2;
import com.yaoxinqi.dao.UserMapper3;
import com.yaoxinqi.dao.impl.UserMapper3Impl;
import com.yaoxinqi.domain.QuaryVo;
import com.yaoxinqi.domain.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.beans.PropertyDescriptor;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Method;
import java.lang.reflect.ParameterizedType;
import java.sql.SQLOutput;
import java.util.*;

public class MybatisTest {
    InputStream in;
    SqlSession session;
    UserMapper userMapper;

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
    public void testFindAll(){

        //动态代理，给出代理类
        userMapper = session.getMapper(UserMapper.class);
        List<User> users = userMapper.findAll();
        for(User user:users){
            System.out.println(user);
        }
    }

    @Test
    public void test2() throws IOException {
        //动态代理，给出代理类
        UserMapper2 userMapper2 = session.getMapper(UserMapper2.class);
        List<User> users = userMapper2.findAll();
        for(User user:users){
            System.out.println(user);
        }
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

    update:
        上面不对，mybatis是用反射直接设置属性值，所以不需要get、set方法
        不过你没有指定字段与属性的映射时，mybatis用的是简单映射，就直接字段是什么，属性就是什么，这个时候是要保持一致的
        不过你也可以指定字段与属性的映射关系，那就是mybatis的复杂映射了
     */
//    @Test
//    public void test4() throws Exception{
//        User user = new User();
//        PropertyDescriptor pd = new PropertyDescriptor("id",User.class);
//        System.out.println(pd.getWriteMethod());
//        Method writeMethod = pd.getWriteMethod();//用来写的，执行时告诉他往哪个对象的id写，写什么
//        Method readMethod = pd.getReadMethod();//用来读的，执行时告诉他读哪个对象的id
//        //把获取的列的值，给对象赋值
//        writeMethod.invoke(user,123);
//        System.out.println("直接获取到的："+user.getId());
//        System.out.println("获取到的get方法读到的："+readMethod.invoke(user));
//    }

    @Test
    public void testSaveUser(){
        userMapper = session.getMapper(UserMapper.class);
        User user = new User();
        user.setUserName("呀哈哈");
        user.setUserBirthday(new Date());
        user.setUserAddress("中国");
        user.setUserSex("男");
        userMapper.saveUser(user);
        System.out.println("新增的ID："+user.getUserId());
    }

    @Test
    public void testUpdateUser(){
        userMapper = session.getMapper(UserMapper.class);
        User user = new User();
        user.setUserId(54);
        user.setUserName("呀哈哈");
        user.setUserBirthday(new Date());
        user.setUserAddress("中国");
        user.setUserSex("男");
        userMapper.updateUser(user);
    }

    @Test
    public void testDeleteUser(){
        userMapper = session.getMapper(UserMapper.class);
        userMapper.deleteUser(54);
    }

    @Test
    public void testFindById(){
        userMapper = session.getMapper(UserMapper.class);
        User user = userMapper.findById(48);
        System.out.println(user);
    }

    @Test
    public void testFindByName(){
        userMapper = session.getMapper(UserMapper.class);
        List<User> users = userMapper.findByName("%王%");
        for (User user:users){
            System.out.println(user);
        }
    }

    @Test
    public void testFindTotal(){
        userMapper = session.getMapper(UserMapper.class);
        System.out.println(userMapper.findTotal());
    }

    @Test
    public void testFindByQuaryVo(){
        userMapper = session.getMapper(UserMapper.class);
        User user = new User();
//        user.setUserSex("男");
        user.setUserName("%王%");
        QuaryVo quaryVo = new QuaryVo(user);
        List<User> users = userMapper.findByQuaryVo(quaryVo);
        for(User eacheUser:users){
            System.out.println(eacheUser);
        }
    }


    @AfterMethod
    public void destroy() throws IOException{
        session.commit();
        session.close();
        in.close();
    }
}
