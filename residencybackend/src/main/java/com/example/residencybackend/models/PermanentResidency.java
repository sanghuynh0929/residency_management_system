package com.example.residencybackend.models;

import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table(name="permanent_residency", uniqueConstraints = @UniqueConstraint(columnNames = {"resident_id"}))
public class PermanentResidency {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long link_id;

    @OneToOne(cascade=CascadeType.MERGE)
    @JoinColumn(name="resident_id")
    private Resident resident;

    @ManyToOne(cascade=CascadeType.MERGE)
    @JoinColumn(name="household_id")
    private Household household;
    private String relationshipWithHead;
    private String previousResidency;
    private boolean awayStatus;
    private Date residencyRegistrationDate;
}
