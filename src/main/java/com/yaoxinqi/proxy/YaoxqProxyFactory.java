package com.yaoxinqi.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class YaoxqProxyFactory implements InvocationHandler {

    private Object object;

    public YaoxqProxyFactory(Object object) {
        this.object = object;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("洗手洗手");
        method.invoke(object, args);
        System.out.println("-------------");
        return null;
    }

    public Object getDaoProxy() {
        return Proxy.newProxyInstance(
                object.getClass().getClassLoader(),
                object.getClass().getInterfaces(),
                new YaoxqProxyFactory(object)
        );
    }
}
