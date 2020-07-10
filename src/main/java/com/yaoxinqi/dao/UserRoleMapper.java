package com.yaoxinqi.dao;

import com.yaoxinqi.domain.Role;
import com.yaoxinqi.domain.UserRole;

import java.util.List;

public interface UserRoleMapper {

    public List<Role> findAllRole();

    public List<UserRole> findAllUser();

    public List<Role> findRoleByUid(Integer uid);
}
