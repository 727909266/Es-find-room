package com.huhaoran.esproject.entity;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "house_tag", schema = "elasticsearch", catalog = "")
public class HouseTagEntity {
    private int houseId;
    private int id;
    private String name;

    @Basic
    @Column(name = "house_id")
    public int getHouseId() {
        return houseId;
    }

    public void setHouseId(int houseId) {
        this.houseId = houseId;
    }

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        HouseTagEntity that = (HouseTagEntity) o;
        return houseId == that.houseId &&
                id == that.id &&
                Objects.equals(name, that.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(houseId, id, name);
    }
}
