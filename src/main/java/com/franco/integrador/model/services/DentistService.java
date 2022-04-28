package com.franco.integrador.model.services;

import com.franco.integrador.model.entities.Dentist;
import com.franco.integrador.model.repository.DentistRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DentistService {

    @Autowired
    DentistRepository repository ;

    Logger logger = LoggerFactory.getLogger(DentistService.class);

    public DentistService(){}

    public Dentist addDentist(Dentist dentist ){ return repository.save(dentist) ; }

    public List<Dentist> getAllDentist(){ return repository.findAll() ; }

    public Dentist getDentistByID( Long id ){
        logger.info("BUSCANDO CON EL ID: " + id);
        return repository.findById(id).get() ;
    }

    public Dentist getDentistByRegistration(String registration ){ return repository.getDentistByRegistration(registration).get() ; }

    public Dentist deleteDentist ( String name , String lastName , String registration ) { return repository.deleteDentist(name , lastName , registration).get() ; }

    public void deleteByID( Long id ){ repository.deleteById(id); }

}
