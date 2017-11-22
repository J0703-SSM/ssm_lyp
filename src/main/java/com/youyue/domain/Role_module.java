package com.youyue.domain;

public class Role_module {
    private Integer roleId;

    private Integer moduleId;


    public Role_module(Integer roleId, Integer moduleId) {
        this.roleId = roleId;
        this.moduleId = moduleId;
    }

    public Role_module() {

    }

    public Integer getRoleId() {
        return roleId;
    }

    public void setRoleId(Integer roleId) {
        this.roleId = roleId;
    }

    public Integer getModuleId() {
        return moduleId;
    }

    public void setModuleId(Integer moduleId) {
        this.moduleId = moduleId;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", roleId=").append(roleId);
        sb.append(", moduleId=").append(moduleId);
        sb.append("]");
        return sb.toString();
    }
}