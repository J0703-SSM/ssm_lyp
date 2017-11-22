package com.youyue.domain;

import java.util.Date;
import java.util.List;

public class Admin_info {
    private Integer adminId;

    private String adminCode;

    private String password;

    private String name;

    private String telephone;

    private String email;

    private Date enrolldate;

    private List<Admin_role> role;

    public List<Admin_role> getRole() {
        return role;
    }

    public void setRole(List<Admin_role> role) {
        this.role = role;
    }

    public Admin_info(Integer adminId, String adminCode, String password, String name, String telephone, String email, Date enrolldate) {
        this.adminId = adminId;
        this.adminCode = adminCode;
        this.password = password;
        this.name = name;
        this.telephone = telephone;
        this.email = email;
        this.enrolldate = enrolldate;
    }

    public Admin_info() {
        super();
    }

    public Integer getAdminId() {
        return adminId;
    }

    public void setAdminId(Integer adminId) {
        this.adminId = adminId;
    }

    public String getAdminCode() {
        return adminCode;
    }

    public void setAdminCode(String adminCode) {
        this.adminCode = adminCode == null ? null : adminCode.trim();
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password == null ? null : password.trim();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone == null ? null : telephone.trim();
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email == null ? null : email.trim();
    }

    public Date getEnrolldate() {
        return enrolldate;
    }

    public void setEnrolldate(Date enrolldate) {
        this.enrolldate = enrolldate;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", adminId=").append(adminId);
        sb.append(", adminCode=").append(adminCode);
        sb.append(", password=").append(password);
        sb.append(", name=").append(name);
        sb.append(", telephone=").append(telephone);
        sb.append(", email=").append(email);
        sb.append(", enrolldate=").append(enrolldate);
        sb.append("]");
        return sb.toString();
    }
}