package com.youyue.domain;

public class Role_info {
    private Integer roleId;

    private String name;

    public Role_info(Integer roleId, String name) {
        this.roleId = roleId;
        this.name = name;
    }

    public Role_info() {
    }

    public Integer getRoleId() {
        return roleId;
    }

    public void setRoleId(Integer roleId) {
        this.roleId = roleId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", roleId=").append(roleId);
        sb.append(", name=").append(name);
        sb.append("]");
        return sb.toString();
    }
}