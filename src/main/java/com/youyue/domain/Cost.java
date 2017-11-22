package com.youyue.domain;

import java.util.Date;

public class Cost {
    private Integer costId;

    private String name;

    private Integer baseDuration;

    private Integer baseCost;

    private Integer unitCost;

    private String status;

    private String descr;

    private Date creatime;

    private Date startime;

    private String costType;

    public Cost(Integer costId, String name, Integer baseDuration, Integer baseCost, Integer unitCost, String status, String descr, Date creatime, Date startime, String costType) {
        this.costId = costId;
        this.name = name;
        this.baseDuration = baseDuration;
        this.baseCost = baseCost;
        this.unitCost = unitCost;
        this.status = status;
        this.descr = descr;
        this.creatime = creatime;
        this.startime = startime;
        this.costType = costType;
    }

    public Cost() {
        super();
    }

    public Integer getCostId() {
        return costId;
    }

    public void setCostId(Integer costId) {
        this.costId = costId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public Integer getBaseDuration() {
        return baseDuration;
    }

    public void setBaseDuration(Integer baseDuration) {
        this.baseDuration = baseDuration;
    }

    public Integer getBaseCost() {
        return baseCost;
    }

    public void setBaseCost(Integer baseCost) {
        this.baseCost = baseCost;
    }

    public Integer getUnitCost() {
        return unitCost;
    }

    public void setUnitCost(Integer unitCost) {
        this.unitCost = unitCost;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status == null ? null : status.trim();
    }

    public String getDescr() {
        return descr;
    }

    public void setDescr(String descr) {
        this.descr = descr == null ? null : descr.trim();
    }

    public Date getCreatime() {
        return creatime;
    }

    public void setCreatime(Date creatime) {
        this.creatime = creatime;
    }

    public Date getStartime() {
        return startime;
    }

    public void setStartime(Date startime) {
        this.startime = startime;
    }

    public String getCostType() {
        return costType;
    }

    public void setCostType(String costType) {
        this.costType = costType == null ? null : costType.trim();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", costId=").append(costId);
        sb.append(", name=").append(name);
        sb.append(", baseDuration=").append(baseDuration);
        sb.append(", baseCost=").append(baseCost);
        sb.append(", unitCost=").append(unitCost);
        sb.append(", status=").append(status);
        sb.append(", descr=").append(descr);
        sb.append(", creatime=").append(creatime);
        sb.append(", startime=").append(startime);
        sb.append(", costType=").append(costType);
        sb.append("]");
        return sb.toString();
    }
}