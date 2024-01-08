package com.example.residencybackend.models;

import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table(name="permanent_residency", uniqueConstraints = @UniqueConstraint(columnNames = {"resident_id", "household_id"}))
public class PermanentResidency {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long permanentResidencyId;

    @OneToOne(cascade=CascadeType.MERGE, fetch=FetchType.LAZY, optional = false)
    @JoinColumn(name="resident_id")
    private Resident resident;

    @OneToOne(cascade=CascadeType.MERGE, fetch=FetchType.LAZY, optional = false)
    @JoinColumn(name="household_id")
    private Household household;
    private String relationshipWithHead;
    private String previousResidency;
    private Date residencyRegistrationDate;

    public PermanentResidency(Resident resident, Household household, String relationshipWithHead, String previousResidency, Date residencyRegistrationDate) {
        this.resident = resident;
        this.household = household;
        this.relationshipWithHead = relationshipWithHead;
        this.previousResidency = previousResidency;
        this.residencyRegistrationDate = residencyRegistrationDate;
    }

    public PermanentResidency() {
    }

    public Long getPermanentResidencyId() {
        return permanentResidencyId;
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

    public String getPreviousResidency() {
        return previousResidency;
    }

    public void setPreviousResidency(String previousResidency) {
        this.previousResidency = previousResidency;
    }

    public Date getResidencyRegistrationDate() {
        return residencyRegistrationDate;
    }

    public void setResidencyRegistrationDate(Date residencyRegistrationDate) {
        this.residencyRegistrationDate = residencyRegistrationDate;
    }
}
