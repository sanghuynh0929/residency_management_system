package com.example.residencybackend;

import com.example.residencybackend.models.Resident;
import com.example.residencybackend.repositories.ResidentRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Date;

@SpringBootApplication
public class ResidencyBackendApplication implements CommandLineRunner {
	private static final Logger logger =
			LoggerFactory.getLogger(ResidencyBackendApplication.class);
	private final ResidentRepository repository;
	public ResidencyBackendApplication(ResidentRepository repository) {
		this.repository = repository;
	}
	public static void main(String[] args) {
		SpringApplication.run(ResidencyBackendApplication.class, args);
	}

	// Backend Application Run Method
	@Override
	public void run(String... args) throws Exception {
		repository.save(new Resident("Huynh Sang", "001203031234", new Date(2003, 9, 29),
				"male", "Vietnamese", "Kinh", "Hai Duong, Huong Tra, Thua-Thien Hue"));

		repository.save(new Resident("Mai Chien Huu", "001303041234", new Date(2002, 1, 1),
				"male", "Vietnamese", "Kinh", "Khuong Trung, Thanh Xuan, Ha Noi"));

		for (Resident resident : repository.findAll()) {
			logger.info("ID Number: {}, Full Name: {}",
					resident.getIdentificationNumber(), resident.getFullName());
		}
		logger.info("{}", repository.findByIdentificationNumber("001203031234").get(0).getFullName());
	}
}
