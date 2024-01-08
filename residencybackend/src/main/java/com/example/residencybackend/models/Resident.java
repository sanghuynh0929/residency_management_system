package com.example.residencybackend.models;

import jakarta.persistence.*;

import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "resident",
        uniqueConstraints = @UniqueConstraint(columnNames = "identification_number"))
public class Resident implements Serializable {

    //region Fields
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long residentId;
    private String identificationNumber;
    private String fullName;
    private Date dateOfBirth;
    private String gender;
    private String nationality, ethnicity;
    private String placeOfOrigin;
    //endregion

    //region Constructors
    public Resident() {
    }

    public Resident(String identificationNumber, String fullName, Date dateOfBirth, String gender, String nationality, String ethnicity, String placeOfOrigin) {
        this.identificationNumber = identificationNumber;
        this.fullName = fullName;
        this.dateOfBirth = dateOfBirth;
        this.gender = gender;
        this.nationality = nationality;
        this.ethnicity = ethnicity;
        this.placeOfOrigin = placeOfOrigin;
    }
    //endregion

    //region Getters & Setters
    public String getIdentificationNumber() {
        return identificationNumber;
    }

    public void setIdentificationNumber(String identificationNumber) {
        this.identificationNumber = identificationNumber;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getNationality() {
        return nationality;
    }

    public void setNationality(String nationality) {
        this.nationality = nationality;
    }

    public String getEthnicity() {
        return ethnicity;
    }

    public void setEthnicity(String ethnicity) {
        this.ethnicity = ethnicity;
    }

    public String getPlaceOfOrigin() {
        return placeOfOrigin;
    }

    public void setPlaceOfOrigin(String placeOfOrigin) {
        this.placeOfOrigin = placeOfOrigin;
    }
    //endregion
}

