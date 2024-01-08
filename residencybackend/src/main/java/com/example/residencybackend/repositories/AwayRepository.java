package com.example.residencybackend.repositories;

import com.example.residencybackend.models.AwayStatus;
import com.example.residencybackend.models.Resident;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface AwayRepository extends CrudRepository<AwayStatus, Long> {
    @Query("select aw.resident from AwayStatus aw where aw.resident.identificationNumber = ?1")
    AwayStatus findByResidentIdNumber(String id);
}