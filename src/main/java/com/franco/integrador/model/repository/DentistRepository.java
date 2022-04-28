package com.franco.integrador.model.repository;

import com.franco.integrador.model.entities.Dentist;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface DentistRepository extends JpaRepository<Dentist , Long> {
    @Query("SELECT dentists FROM Dentist dentists WHERE dentists.registration = ?1 ")
    public Optional<Dentist> getDentistByRegistration(String registration ) ;
    @Query("DELETE FROM Dentist dentists WHERE dentists.name = ?1 AND dentists.lastName = ?2 AND dentists.registration = ?3")
    public Optional<Dentist> deleteDentist( String name , String lastName , String registration) ;
}
