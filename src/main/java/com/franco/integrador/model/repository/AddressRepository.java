package com.franco.integrador.model.repository;

import com.franco.integrador.model.entities.Address;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
@EnableJpaRepositories
public interface AddressRepository extends JpaRepository<Address , Long> {
    @Query("SELECT addresses FROM Address addresses")
    Optional<List<Address>> getAllAddress() ;
    @Query("SELECT addresses FROM Address addresses WHERE addresses.address = ?1 AND addresses.number = ?2 AND addresses.city = ?3 ")
    Optional<Address> getAddressForAddressName( String address , String number , String city ) ;
}
