package com.yaoxinqi.test;

import com.yaoxinqi.dao.AccountMapper;
import com.yaoxinqi.domain.Account;
import com.yaoxinqi.domain.AccountUser;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class AccountTest {
    InputStream in;
    SqlSession session;
    AccountMapper accountMapper;

    @BeforeMethod
    public void init() throws IOException {
        in = Resources.getResourceAsStream("SqlMapConfig.xml");
        SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();
        SqlSessionFactory factory = builder.build(in);
        session = factory.openSession();
    }

    @AfterMethod
    public void destroy() throws IOException{
        session.commit();
        session.close();
        in.close();
    }

    @Test
    public void testFindAll(){
        accountMapper = session.getMapper(AccountMapper.class);
        List<Account> accounts = accountMapper.findAll();
        for(Account account:accounts){
            System.out.println(account);
        }
    }

    @Test
    public void testFindAllAccount(){
        accountMapper = session.getMapper(AccountMapper.class);
        List<AccountUser> accountusers = accountMapper.findAllAccount();
        for(AccountUser accountUser:accountusers){
            System.out.println(accountUser);
        }
    }
}
