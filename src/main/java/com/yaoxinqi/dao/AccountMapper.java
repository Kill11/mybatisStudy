package com.yaoxinqi.dao;

import com.yaoxinqi.domain.Account;
import com.yaoxinqi.domain.AccountUser;

import java.util.List;

public interface AccountMapper {

    List<Account> findAll();

    List<AccountUser> findAllAccount();

}
