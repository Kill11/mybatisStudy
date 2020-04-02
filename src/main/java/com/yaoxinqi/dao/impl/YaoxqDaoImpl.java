package com.yaoxinqi.dao.impl;


import com.yaoxinqi.dao.YaoxqDao;

public class YaoxqDaoImpl implements YaoxqDao {

    @Override
    public void eat() {
        System.out.println("我吃饭了");
    }

    @Override
    public void cook() {
        System.out.println("做饭做饭");
    }

    @Override
    public void cook(String food) {
        System.out.println("做饭做饭："+food);
    }


}
