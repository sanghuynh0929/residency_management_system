package com.example.residencybackend.restcontrollers;

import com.example.residencybackend.models.Resident;
import com.example.residencybackend.repositories.ResidentRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ResidentController {
    // Return on http://localhost:8080/api/{endpoint}
    private final ResidentRepository repository;
    public ResidentController(ResidentRepository repository) {
        this.repository = repository;
    }
    @GetMapping("/residents")
    public Iterable<Resident> getResidents() {
        return repository.findAll();
    }
}
