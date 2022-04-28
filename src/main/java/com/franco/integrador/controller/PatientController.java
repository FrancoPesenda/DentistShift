package com.franco.integrador.controller;

import com.franco.integrador.model.entities.Address;
import com.franco.integrador.model.entities.Patient;
import com.franco.integrador.model.exceptions.ResourceNotFoundException;
import com.franco.integrador.model.services.AddressService;
import com.franco.integrador.model.services.PatientService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/patient")
@CrossOrigin(origins = "*", maxAge = 3600)
public class PatientController {

    @Autowired
    PatientService service ;
    @Autowired
    AddressService addressService ;

    Logger logger = LoggerFactory.getLogger(PatientController.class) ;

    @GetMapping
    public ResponseEntity<List<Patient>> getAllAddress() throws ResourceNotFoundException{

        List<Patient> listTemp = service.getAllPatientes() ;

        if (listTemp != null ){
            return ResponseEntity.ok(listTemp) ;
        }else{
            throw new ResourceNotFoundException("NO SE ENCONTRO NINGUN PACIENTE") ;
        }
    }

    @GetMapping("/getById/{id}")
    public ResponseEntity<Patient> getById(@PathVariable Long id){
        logger.info("BUSCANDO POR ID: " + id);
        return ResponseEntity.ok(service.getPatientByID(id));
    }

    @GetMapping("/getNameAndLastName")
    public ResponseEntity<Patient> getByNameAndLastName(@RequestParam String name , @RequestParam String lastName ){
        return ResponseEntity.ok(service.getPatientByNameAndLastName(name,lastName)) ;
    }

    @PostMapping("/add")
    public ResponseEntity<Patient> save( @RequestBody Patient patient ){
        Patient patientTemp = null ;
        Address addressTemp = null ;
        try {

            patientTemp = service.getPatientByNameAndLastName(patient.getName(),patient.getLastName()) ;
            addressTemp = addressService.getAddressByAddress(patient.getAddress().getAddress(), patient.getAddress().getNumber(),patient.getAddress().getCity()) ;

        }catch (Exception e ){

        }
        if (patientTemp == null){
            try{
                if (addressTemp == null){
                    addressService.addAddress(patient.getAddress()) ;
                }
                return ResponseEntity.ok(service.addPatient(patient)) ;
            }catch( Exception e ){
                throw e ;
            }
        }else {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build() ;
        }
    }

}
