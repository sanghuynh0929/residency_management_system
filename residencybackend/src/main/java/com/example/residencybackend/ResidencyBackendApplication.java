package com.example.residencybackend;

import com.example.residencybackend.models.Household;
import com.example.residencybackend.models.Resident;
import com.example.residencybackend.repositories.HouseholdRepository;
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
	private final ResidentRepository residentRepository;
	private final HouseholdRepository householdRepository;

	public ResidencyBackendApplication(ResidentRepository residentRepository, HouseholdRepository householdRepository) {
		this.residentRepository = residentRepository;
		this.householdRepository = householdRepository;
	}
	public static void main(String[] args) {
		SpringApplication.run(ResidencyBackendApplication.class, args);
	}

	// Backend Application Run Method
	@Override
	public void run(String... args) throws Exception {
		Resident sang = new Resident("001203031234", "Huynh Sang", new Date(2003, 9, 29),
				"male", "Vietnamese", "Kinh", "Hai Duong, Huong Tra, Thua-Thien Hue");
		residentRepository.save(sang);

		residentRepository.save(new Resident("001303041234", "Mai Chien Huu", new Date(2002, 1, 1),
				"male", "Vietnamese", "Kinh", "Khuong Trung, Thanh Xuan, Ha Noi"));

		for (Resident resident : residentRepository.findAll()) {
			logger.info("ID Number: {}, Full Name: {}",
					resident.getIdentificationNumber(), resident.getFullName());
		}
		logger.info("{}", residentRepository.findByIdentificationNumber("001203031234").get(0).getFullName());
		householdRepository.save(new Household(sang, "So 12 ngo 92 pho Vuong Thua Vu", "Khuong Trung", "Thanh Xuan", "Ha Noi"));
		logger.info("{}", householdRepository.findByHouseholdHead(residentRepository.findByIdentificationNumber("001203031234").get(0)).get(0).getAddress());

	}
}
