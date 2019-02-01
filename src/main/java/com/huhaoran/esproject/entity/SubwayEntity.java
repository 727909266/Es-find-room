package com.huhaoran.esproject.entity;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "subway", schema = "elasticsearch")
public class SubwayEntity {
    private int id;
    private String name;
    private String cityEnName;

    @Id
    @Column(name = "id")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "name")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Basic
    @Column(name = "city_en_name")
    public String getCityEnName() {
        return cityEnName;
    }

    public void setCityEnName(String cityEnName) {
        this.cityEnName = cityEnName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SubwayEntity that = (SubwayEntity) o;
        return id == that.id &&
                Objects.equals(name, that.name) &&
                Objects.equals(cityEnName, that.cityEnName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, cityEnName);
    }
}
