package com.example.residencybackend.models;

import jakarta.persistence.*;

@Entity
@Table(name="household")
public class Household {
    //region Fields
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long householdId;

    @OneToOne
    @JoinColumn(name = "resident_id")
    private Resident head;
    private String address, ward, district, city;

}
