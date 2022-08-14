package com.app;

import java.time.LocalDate;
import java.util.ArrayList;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import com.app.entity.Consultation;
import com.app.entity.Doctor;
import com.app.entity.Patient;
import com.app.repository.ConsultationRepository;
import com.app.repository.DoctorRepository;
import com.app.repository.PatientRepository;

@SpringBootApplication
@EnableCaching
public class MedwayApplication {
	
	@Autowired
	PatientRepository patientRepository;
	
	@Autowired
	DoctorRepository doctorRepository;
	
	@Autowired
	ConsultationRepository consultationRepository;
	
	@PostConstruct
	public void initDB() {
		Patient patient = new Patient(Long.valueOf(100), "Tushar Nath", Long.valueOf(111122223333L), LocalDate.parse("1999-08-10"),"135, Meghmallar, Block GH 14, Beltola","Guwahati", Long.valueOf(9990843434L), new ArrayList<>());
		Doctor doctor1 = new Doctor(Long.valueOf(100), "Aman Singhania", Long.valueOf(222233334444L), "33, Pocket A, Phase 45, Ganeshguri", "Guwahati", Long.valueOf(9311733366L), "Cardiologist", new ArrayList<>());
		Doctor doctor2 = new Doctor(Long.valueOf(101), "Raj Patel", Long.valueOf(333344445555L), "B-362, Near to ICICI Bank, Block B, Meera Bagh, Narengi", "Guwahati", Long.valueOf(9837199390L), "Dermatologist", new ArrayList<>());
		patient.setEmail("tushar@medway.com");
		patient.setPassword("tushar");
		doctor1.setEmail("aman@medway.com");
		doctor1.setPassword("aman");
		doctor2.setEmail("raj@medway.com");
		doctor2.setPassword("raj");
		patientRepository.save(patient);
		doctorRepository.save(doctor1);
		doctorRepository.save(doctor2);
		Consultation consultation1 = new Consultation(LocalDate.parse("2021-08-19"), "Heart failure", "Lescol XL, Ranolazine, Nitroglycerin", "Coronary Artery Disease", patient, doctor1);
		Consultation consultation2 = new Consultation(LocalDate.parse("2021-09-02"), "Toxic epidermal necrolysis (TEN)", "Dexamethasone, Ibuprofen", "Stevens-Johnson Syndrome", patient, doctor2);
		consultationRepository.save(consultation1);
		consultationRepository.save(consultation2);
	}
	
	public static void main(String[] args) {
		SpringApplication.run(MedwayApplication.class, args);
	}

}
