package com.franco.integrador.controller;

import com.franco.integrador.model.entities.Address;
import com.franco.integrador.model.entities.Patient;
import com.franco.integrador.model.services.AddressService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;

class AddressControllerTest {
    @Autowired
    AddressService service ;

    @Test
    void getForId() {

        service.addAddress(new Address(Long.valueOf(1),"Altolaguirre",new Patient(Long.valueOf(1),"Franco","Pesenda",new Date())));

        Assertions.assertEquals("Altolaguirre",service.getAddressByID(Long.valueOf(1)).getAddress());

    }

    @Test
    void getForAddress() {
    }

    @Test
    void save() {
    }
}