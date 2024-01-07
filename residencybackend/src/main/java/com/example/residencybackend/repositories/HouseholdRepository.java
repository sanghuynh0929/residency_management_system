package com.example.residencybackend.repositories;

import com.example.residencybackend.models.Household;
import com.example.residencybackend.models.Resident;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface HouseholdRepository extends CrudRepository<Household, Long> {
    List<Household> findByHouseholdHead(Resident householdHead);
}
