package com.example.residencybackend.models;

import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table(name = "away_status")
public class AwayStatus {
    @Id
    private Long statusId;

    @OneToOne(cascade = CascadeType.MERGE, optional = false, fetch = FetchType.LAZY)
    @JoinColumn(name="resident_id")
    private Resident resident;
    private Date awayFrom;
    private Date awayUntil;
    private String awayAddress;
    private String reason;


    public AwayStatus(Resident resident, Date awayFrom, Date awayUntil, String awayAddress, String reason) {
        this.resident = resident;
        this.awayFrom = awayFrom;
        this.awayUntil = awayUntil;
        this.awayAddress = awayAddress;
        this.reason = reason;
    }

    public AwayStatus() {

    }

    public Resident getResident() {
        return resident;
    }

    public void setResident(Resident resident) {
        this.resident = resident;
    }

    public Date getAwayFrom() {
        return awayFrom;
    }

    public void setAwayFrom(Date awayFrom) {
        this.awayFrom = awayFrom;
    }

    public Date getAwayUntil() {
        return awayUntil;
    }

    public void setAwayUntil(Date awayUntil) {
        this.awayUntil = awayUntil;
    }

    public String getAwayAddress() {
        return awayAddress;
    }

    public void setAwayAddress(String awayAddress) {
        this.awayAddress = awayAddress;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }
}
