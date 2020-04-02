package com.yaoxinqi.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class NonImplYaoxqProxyFactory implements InvocationHandler {

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("洗手洗手");
        if (args != null && args.length == 1 && args[0] instanceof String) {
            System.out.println("吃饭吃饭：" + args[0]);
        } else {
            System.out.println("吃饭吃饭");
        }
        System.out.println("-------------");
        return null;
    }

    public Object getDaoProxy(Class c) {
        return Proxy.newProxyInstance(
                c.getClassLoader(),
                new Class[]{c},
                new NonImplYaoxqProxyFactory()
        );
    }
}
