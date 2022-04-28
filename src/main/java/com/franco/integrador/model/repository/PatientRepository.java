package com.franco.integrador.model.repository;


import com.franco.integrador.model.entities.Patient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
@Repository
@EnableJpaRepositories
public interface PatientRepository extends JpaRepository<Patient , Long> {
    @Query("SELECT patients FROM Patient patients WHERE patients.name = ?1 and patients.lastName = ?2")
    Optional<Patient> getPatientForNameAndLastName( String name , String lastName ) ;
}
