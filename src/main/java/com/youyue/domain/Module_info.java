package com.youyue.domain;

public class Module_info {
    private Integer moduleId;

    private String name;

    private Module_info module_info;

    public Module_info getModule_info() {
        return module_info;
    }

    public void setModule_info(Module_info module_info) {
        this.module_info = module_info;
    }

    public Module_info(Integer moduleId, String name) {
        this.moduleId = moduleId;
        this.name = name;
    }

    public Module_info() {
        super();
    }

    public Integer getModuleId() {
        return moduleId;
    }

    public void setModuleId(Integer moduleId) {
        this.moduleId = moduleId;
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
        sb.append(", moduleId=").append(moduleId);
        sb.append(", name=").append(name);
        sb.append("]");
        return sb.toString();
    }
}