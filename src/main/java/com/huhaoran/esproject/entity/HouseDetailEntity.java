package com.huhaoran.esproject.entity;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "house_detail", schema = "elasticsearch", catalog = "")
public class HouseDetailEntity {
    private int id;
    private String description;
    private String layoutDesc;
    private String traffic;
    private String roundService;
    private int rentWay;
    private String address;
    private Integer subwayLineId;
    private String subwayLineName;
    private Integer subwayStationId;
    private String subwayStationName;
    private int houseId;

    @Id
    @Column(name = "id")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "description")
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Basic
    @Column(name = "layout_desc")
    public String getLayoutDesc() {
        return layoutDesc;
    }

    public void setLayoutDesc(String layoutDesc) {
        this.layoutDesc = layoutDesc;
    }

    @Basic
    @Column(name = "traffic")
    public String getTraffic() {
        return traffic;
    }

    public void setTraffic(String traffic) {
        this.traffic = traffic;
    }

    @Basic
    @Column(name = "round_service")
    public String getRoundService() {
        return roundService;
    }

    public void setRoundService(String roundService) {
        this.roundService = roundService;
    }

    @Basic
    @Column(name = "rent_way")
    public int getRentWay() {
        return rentWay;
    }

    public void setRentWay(int rentWay) {
        this.rentWay = rentWay;
    }

    @Basic
    @Column(name = "address")
    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Basic
    @Column(name = "subway_line_id")
    public Integer getSubwayLineId() {
        return subwayLineId;
    }

    public void setSubwayLineId(Integer subwayLineId) {
        this.subwayLineId = subwayLineId;
    }

    @Basic
    @Column(name = "subway_line_name")
    public String getSubwayLineName() {
        return subwayLineName;
    }

    public void setSubwayLineName(String subwayLineName) {
        this.subwayLineName = subwayLineName;
    }

    @Basic
    @Column(name = "subway_station_id")
    public Integer getSubwayStationId() {
        return subwayStationId;
    }

    public void setSubwayStationId(Integer subwayStationId) {
        this.subwayStationId = subwayStationId;
    }

    @Basic
    @Column(name = "subway_station_name")
    public String getSubwayStationName() {
        return subwayStationName;
    }

    public void setSubwayStationName(String subwayStationName) {
        this.subwayStationName = subwayStationName;
    }

    @Basic
    @Column(name = "house_id")
    public int getHouseId() {
        return houseId;
    }

    public void setHouseId(int houseId) {
        this.houseId = houseId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        HouseDetailEntity that = (HouseDetailEntity) o;
        return id == that.id &&
                rentWay == that.rentWay &&
                houseId == that.houseId &&
                Objects.equals(description, that.description) &&
                Objects.equals(layoutDesc, that.layoutDesc) &&
                Objects.equals(traffic, that.traffic) &&
                Objects.equals(roundService, that.roundService) &&
                Objects.equals(address, that.address) &&
                Objects.equals(subwayLineId, that.subwayLineId) &&
                Objects.equals(subwayLineName, that.subwayLineName) &&
                Objects.equals(subwayStationId, that.subwayStationId) &&
                Objects.equals(subwayStationName, that.subwayStationName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, description, layoutDesc, traffic, roundService, rentWay, address, subwayLineId, subwayLineName, subwayStationId, subwayStationName, houseId);
    }
}
