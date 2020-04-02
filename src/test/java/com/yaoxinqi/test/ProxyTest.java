package com.yaoxinqi.test;


import com.yaoxinqi.dao.YaoxqDao;
import com.yaoxinqi.dao.impl.YaoxqDaoImpl;
import com.yaoxinqi.proxy.NonImplYaoxqProxyFactory;
import com.yaoxinqi.proxy.YaoxqProxyFactory;
import org.testng.annotations.Test;

public class ProxyTest {
    @Test
    public void test(){
        //不写实现类的方式：不需要被代理对象的实例，直接给接口就行了（因为不需要执行人家的方法，只要生成人家的代理类就行了）
        NonImplYaoxqProxyFactory nonImplYaoxqProxyFactory = new NonImplYaoxqProxyFactory();
        YaoxqDao yaoxqDao1 = (YaoxqDao) nonImplYaoxqProxyFactory.getDaoProxy(YaoxqDao.class);
        yaoxqDao1.eat();
        yaoxqDao1.cook("哈哈");

        //写实现类的方式：需要被代理对象的实例（毕竟要执行人家的方法）
        YaoxqProxyFactory yaoxqProxyFactory = new YaoxqProxyFactory(new YaoxqDaoImpl());
        YaoxqDao yaoxqDao = (YaoxqDao) yaoxqProxyFactory.getDaoProxy();
        yaoxqDao.eat();
        yaoxqDao.cook("青菜");
    }
}
