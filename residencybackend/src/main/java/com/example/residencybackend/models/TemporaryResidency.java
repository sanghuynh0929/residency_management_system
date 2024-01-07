package com.example.residencybackend.models;

import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table(name="temporary_residency")
public class TemporaryResidency {
    @Id
    @OneToOne(cascade=CascadeType.MERGE)
    @JoinColumn(name="resident_id")
    private Resident resident;
    private Date startDate;
    private Date endDate;
    private String temporaryAddress;
    private String reason;
}
