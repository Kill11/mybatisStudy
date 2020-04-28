package com.yaoxinqi.domain;

import java.io.Serializable;
import java.util.List;

public class Role implements Serializable {

    private Integer userRoleId;
    private String roleName;
    private String roleDesc;
    private List<UserRole> userRoles;

    public Integer getUserRoleId() {
        return userRoleId;
    }

    @Override
    public String toString() {
        return "Role{" +
                "userRoleId=" + userRoleId +
                ", roleName='" + roleName + '\'' +
                ", roleDesc='" + roleDesc + '\'' +
                ", userRoles=" + userRoles +
                '}';
    }

    public void setUserRoleId(Integer userRoleId) {
        this.userRoleId = userRoleId;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    public String getRoleDesc() {
        return roleDesc;
    }

    public void setRoleDesc(String roleDesc) {
        this.roleDesc = roleDesc;
    }

    public List<UserRole> getUserRoles() {
        return userRoles;
    }

    public void setUserRoles(List<UserRole> userRoles) {
        this.userRoles = userRoles;
    }
}
