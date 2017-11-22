package com.youyue.domain;

import java.util.List;

public class Admin_role {
    private Integer adminId;

    private Integer roleId;

    private List<Role_module> roleModules;
    private Role_info roleInfo;

    public List<Role_module> getRoleModules() {
        return roleModules;
    }

    public void setRoleModules(List<Role_module> roleModules) {
        this.roleModules = roleModules;
    }

    public Role_info getRoleInfo() {
        return roleInfo;
    }

    public void setRoleInfo(Role_info roleInfo) {
        this.roleInfo = roleInfo;
    }

    public Admin_role(Integer adminId, Integer roleId) {
        this.adminId = adminId;
        this.roleId = roleId;
    }

    public Admin_role() {
        super();
    }

    public Integer getAdminId() {
        return adminId;
    }

    public void setAdminId(Integer adminId) {
        this.adminId = adminId;
    }

    public Integer getRoleId() {
        return roleId;
    }

    public void setRoleId(Integer roleId) {
        this.roleId = roleId;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", adminId=").append(adminId);
        sb.append(", roleId=").append(roleId);
        sb.append("]");
        return sb.toString();
    }
}