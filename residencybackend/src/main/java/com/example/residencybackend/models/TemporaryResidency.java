package com.example.residencybackend.models;

import jakarta.annotation.Nonnull;
import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table(name="temporary_residency", uniqueConstraints = @UniqueConstraint(columnNames = {"resident_id", "household_id"}))
public class TemporaryResidency {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long temporaryResidencyId;

    @OneToOne(cascade = CascadeType.MERGE, fetch = FetchType.LAZY)
    @JoinColumn(name = "resident_id")
    private Resident resident;

    @OneToOne(cascade = CascadeType.MERGE, fetch = FetchType.LAZY)
    @JoinColumn(name = "household_id")
    private Household household;
    private String relationshipWithHead;
    private Date resideUntil;

    public TemporaryResidency(Resident resident, Household household, String relationshipWithHead, Date resideUntil) {
        this.resident = resident;
        this.household = household;
        this.relationshipWithHead = relationshipWithHead;
        this.resideUntil = resideUntil;
    }

    public TemporaryResidency() {
    }

    public Long getTemporaryResidencyId() {
        return temporaryResidencyId;
    }

    public Resident getResident() {
        return resident;
    }

    public void setResident(Resident resident) {
        this.resident = resident;
    }

    public Household getHousehold() {
        return household;
    }

    public void setHousehold(Household household) {
        this.household = household;
    }

    public String getRelationshipWithHead() {
        return relationshipWithHead;
    }

    public void setRelationshipWithHead(String relationshipWithHead) {
        this.relationshipWithHead = relationshipWithHead;
    }

    public Date getResideUntil() {
        return resideUntil;
    }

    public void setResideUntil(Date resideUntil) {
        this.resideUntil = resideUntil;
    }
}
