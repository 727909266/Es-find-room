package com.huhaoran.esproject.entity;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "support_address", schema = "elasticsearch")
public class SupportAddressEntity {
    private int id;
    private String belongTo;
    private String enName;
    private String cnName;
    private String level;
    private double baiduMapLng;
    private double baiduMapLat;

    @Id
    @Column(name = "id")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "belong_to")
    public String getBelongTo() {
        return belongTo;
    }

    public void setBelongTo(String belongTo) {
        this.belongTo = belongTo;
    }

    @Basic
    @Column(name = "en_name")
    public String getEnName() {
        return enName;
    }

    public void setEnName(String enName) {
        this.enName = enName;
    }

    @Basic
    @Column(name = "cn_name")
    public String getCnName() {
        return cnName;
    }

    public void setCnName(String cnName) {
        this.cnName = cnName;
    }

    @Basic
    @Column(name = "level")
    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }

    @Basic
    @Column(name = "baidu_map_lng")
    public double getBaiduMapLng() {
        return baiduMapLng;
    }

    public void setBaiduMapLng(double baiduMapLng) {
        this.baiduMapLng = baiduMapLng;
    }

    @Basic
    @Column(name = "baidu_map_lat")
    public double getBaiduMapLat() {
        return baiduMapLat;
    }

    public void setBaiduMapLat(double baiduMapLat) {
        this.baiduMapLat = baiduMapLat;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SupportAddressEntity that = (SupportAddressEntity) o;
        return id == that.id &&
                Double.compare(that.baiduMapLng, baiduMapLng) == 0 &&
                Double.compare(that.baiduMapLat, baiduMapLat) == 0 &&
                Objects.equals(belongTo, that.belongTo) &&
                Objects.equals(enName, that.enName) &&
                Objects.equals(cnName, that.cnName) &&
                Objects.equals(level, that.level);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, belongTo, enName, cnName, level, baiduMapLng, baiduMapLat);
    }
}
