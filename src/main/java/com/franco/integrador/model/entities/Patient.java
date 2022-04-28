package com.franco.integrador.model.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.springframework.data.annotation.Id;

import javax.persistence.*;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "patients")
public class Patient {

    @Id
    @javax.persistence.Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id ;
    @Column
    private String name ;
    @Column
    private String lastName ;
    @Column
    private Date dischargeDate ;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "address_id" )
    private Address address;
    @OneToMany( mappedBy = "patient" , fetch = FetchType.EAGER , cascade = CascadeType.ALL)
    @Column(name = "turn_id")
    @JsonIgnore
    private Set<Turn> turnSet ;

    public Patient(){

    }

    public Patient(Long id, String name, String lastName, Date dischargeDate, Address address, Set<Turn> turnSet) {
        this.id = id;
        this.name = name;
        this.lastName = lastName;
        this.dischargeDate = dischargeDate;
        this.address = address;
        this.turnSet = turnSet;
    }

    public Patient(String name, String lastName, Date dischargeDate, Address address, Set<Turn> turnSet) {
        this.name = name;
        this.lastName = lastName;
        this.dischargeDate = dischargeDate;
        this.address = address;
        this.turnSet = turnSet;
    }

    public Patient(String name, String lastName, Date dischargeDate, Address address) {
        this.name = name;
        this.lastName = lastName;
        this.dischargeDate = dischargeDate;
        this.address = address;
    }

    public Patient(Long id, String name, String lastName, Date dischargeDate, Address address) {
        this.id = id;
        this.name = name;
        this.lastName = lastName;
        this.dischargeDate = dischargeDate;
        this.address = address;
    }

    public Patient(Long id, String name, String lastName, Date dischargeDate) {
        this.id = id;
        this.name = name;
        this.lastName = lastName;
        this.dischargeDate = dischargeDate;
        this.turnSet = new HashSet<>() ;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Date getDischargeDate() {
        return dischargeDate;
    }

    public void setDischargeDate(Date dischargeDate) {
        this.dischargeDate = dischargeDate;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public Set<Turn> getTurnSet() {
        return turnSet;
    }

    public void setTurnSet(Set<Turn> turnSet) {
        this.turnSet = turnSet;
    }
}
