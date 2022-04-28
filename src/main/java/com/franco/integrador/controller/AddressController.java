package com.franco.integrador.controller;

import com.franco.integrador.model.entities.Address;
import com.franco.integrador.model.exceptions.ResourceNotFoundException;
import com.franco.integrador.model.services.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/address")
@CrossOrigin(origins = "*", maxAge = 3600)
public class AddressController {

    @Autowired
    AddressService service ;

    @GetMapping
    public ResponseEntity<List<Address>> getAllAddress() throws ResourceNotFoundException{
        List<Address> listTemp = service.getAllAddress() ;

        if (listTemp != null ){
            return ResponseEntity.ok(listTemp) ;
        }else{
            throw new ResourceNotFoundException("NO SE ENCONTRO NINGUN DOMICILIO") ;
        }
    }

    @GetMapping("/getForId/{id}")
    public ResponseEntity<Address> getForId( @PathVariable Long id ){
        return ResponseEntity.ok(service.getAddressByID(id)) ;
    }

    @GetMapping("/getForAddress")
    public ResponseEntity<Address> getForAddress( @RequestParam String address ,@RequestParam String number ,@RequestParam String city ){
        return ResponseEntity.ok(service.getAddressByAddress(address , number , city )) ;
    }

    @PostMapping("/add")
    public ResponseEntity<Address> save ( @RequestBody Address address ){

        Address addressTemp = null ;

        try {
            addressTemp = service.getAddressByAddress(address.getAddress() , address.getNumber() , address.getCity()) ;
        }catch (Exception e ){
        }

        if (addressTemp == null){

            return ResponseEntity.ok(service.addAddress(address)) ;
        }
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).build() ;
    }

}
