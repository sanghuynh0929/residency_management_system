package com.example.residencybackend.repositories;

import com.example.residencybackend.models.Resident;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ResidentRepository extends CrudRepository<Resident, Long> {
    List<Resident> findByIdentificationNumber(String identificationNumber);
    List<Resident> findResidentByFullNameContainingIgnoreCase(String name);
}
