package com.franco.integrador.model.services;

import com.franco.integrador.model.entities.Address;
import com.franco.integrador.model.entities.Patient;
import com.franco.integrador.model.repository.PatientRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PatientService {

    @Autowired
    PatientRepository repository ;

    Logger logger = LoggerFactory.getLogger(PatientService.class);

    public Patient addPatient(Patient patient ){
        return repository.save(patient) ;
    }

    public Patient getPatientByNameAndLastName(String name , String lastName ){ return repository.getPatientForNameAndLastName( name , lastName ).get() ; }

    public List<Patient> getAllPatientes(){ return repository.findAll();}

    public Patient getPatientByID( Long id ){
        logger.info("BUSCANDO POR EL ID: " + id);
        return repository.findById(id).get() ; }

}
