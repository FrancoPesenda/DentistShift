package com.franco.integrador.controller;

import com.franco.integrador.model.entities.Dentist;
import com.franco.integrador.model.exceptions.ResourceNotFoundException;
import com.franco.integrador.model.services.DentistService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/dentist")
@CrossOrigin(origins = "*", maxAge = 3600)
public class DentistController {

    @Autowired
    DentistService service ;

    Logger logger = LoggerFactory.getLogger(DentistController.class) ;

    @GetMapping
    public ResponseEntity<List<Dentist>> getAllDentist() throws ResourceNotFoundException{

        List<Dentist> listTemp = service.getAllDentist() ;

        if (listTemp != null ){
            return ResponseEntity.ok(listTemp) ;
        }else{
            throw new ResourceNotFoundException("NO SE ENCONTRO NINGUN DENTISTA") ;
        }

    }

    @GetMapping("/getById/{id}")
    public ResponseEntity<Dentist> getById(@PathVariable Long id ){
        logger.info("BUSCANDO POR ID: " + id);
        return ResponseEntity.ok(service.getDentistByID(id)) ;
    }

    @GetMapping("/getByRegistration")
    public ResponseEntity<Dentist> getByRegistration(@RequestParam String registration ){
        return ResponseEntity.ok(service.getDentistByRegistration(registration)) ;
    }

    @PostMapping("/add")
    public ResponseEntity<Dentist> save(@RequestBody Dentist dentist ){
        Dentist dentistTemp = null ;
        try {
            dentistTemp = service.getDentistByRegistration(dentist.getRegistration()) ;
        }catch (Exception e ){

        }
        if (dentistTemp == null){
            return ResponseEntity.ok(service.addDentist(dentist));
        }else {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Dentist> deleteDentistByID( @PathVariable Long id ){
        Dentist dentistTemp = null ;
        try {
            dentistTemp = service.getDentistByID(id) ;
        }catch (Exception e ){

        }
        if (dentistTemp != null){
            service.deleteByID(id);
            return ResponseEntity.ok(dentistTemp) ;
        }else {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build() ;
        }
    }

    @DeleteMapping("/deleteByData")
    public ResponseEntity<Dentist> deleteDentist (@RequestParam String name , @RequestParam String lastName , @RequestParam String registration ){
        Dentist dentistTemp = null ;
        try {
            dentistTemp = service.getDentistByRegistration(registration) ;
        }catch (Exception e ){

        }
        if (dentistTemp == null){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }else {
            return ResponseEntity.ok(service.deleteDentist(name,lastName,registration)) ;
        }
    }

}
