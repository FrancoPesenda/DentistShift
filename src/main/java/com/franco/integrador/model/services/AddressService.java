package com.franco.integrador.model.services;

import com.franco.integrador.model.entities.Address;
import com.franco.integrador.model.repository.AddressRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AddressService {

    @Autowired
    AddressRepository repository ;

    public AddressService(){}

    public Address addAddress( Address a ){ return repository.save(a) ; }

    public List<Address> getAllAddress(){ return repository.getAllAddress().get();}

    public Address getAddressByID( Long id ){ return repository.findById(id).get() ; }

    public Address getAddressByAddress( String address , String number , String city ){ return repository.getAddressForAddressName( address , number , city ).get() ; }

}
