package com.example.residencybackend.models;

import jakarta.persistence.*;

@Entity
@Table(name="household")
public class Household {
    //region Fields
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long householdId;
    @OneToOne(cascade=CascadeType.MERGE, fetch=FetchType.LAZY, optional = false)
    @JoinColumn(name = "head_id", foreignKey = @ForeignKey(name = "resident_id"))
    private Resident householdHead;
    private String address, ward, district, city;

    public Household() {
    }
    public Household(Resident householdHead, String address, String ward, String district, String city) {
        this.householdHead = householdHead;
        this.address = address;
        this.ward = ward;
        this.district = district;
        this.city = city;
    }

    public Long getHouseholdId() {
        return householdId;
    }

    public Resident getHouseholdHead() {
        return householdHead;
    }

    public void setHouseholdHead(Resident householdHead) {
        this.householdHead = householdHead;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getWard() {
        return ward;
    }

    public void setWard(String ward) {
        this.ward = ward;
    }

    public String getDistrict() {
        return district;
    }

    public void setDistrict(String district) {
        this.district = district;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }
}
