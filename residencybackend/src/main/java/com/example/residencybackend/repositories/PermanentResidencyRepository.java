package com.example.residencybackend.repositories;

import com.example.residencybackend.models.PermanentResidency;
import com.example.residencybackend.models.Resident;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface PermanentResidencyRepository extends CrudRepository<PermanentResidency, Long> {
    @Query("select r from Resident r join PermanentResidency pr on r.identificationNumber = pr.resident.identificationNumber" +
            " where r.identificationNumber = ?1")
    List<PermanentResidency> findPermanentResidencyByHeadId(String headId);

    PermanentResidency findPermanentResidencyByResident(Resident resident);
}
