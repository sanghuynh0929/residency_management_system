package com.example.residencybackend.repositories;

import com.example.residencybackend.models.Household;
import com.example.residencybackend.models.Resident;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface HouseholdRepository extends CrudRepository<Household, Long> {
    @Query("select h from Household h where h.householdHead.identificationNumber = ?1")
    Household findByHouseholdHeadIdNumber(String householdHeadId);
}
