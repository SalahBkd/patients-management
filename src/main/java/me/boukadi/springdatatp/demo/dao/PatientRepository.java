package me.boukadi.springdatatp.demo.dao;

import me.boukadi.springdatatp.demo.entity.Patient;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PatientRepository extends JpaRepository<Patient, Long> {
    Patient findByNom(String nom);
}
