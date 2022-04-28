package com.franco.integrador.model.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.springframework.data.annotation.Id;

import javax.persistence.*;

@Entity
@Table(name = "addresses")
public class Address {

    @Id
    @javax.persistence.Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id ;
    @Column
    private String address ;
    @Column
    private String number ;
    @Column
    private String city ;
    @OneToOne( mappedBy = "address") //ACA PONER COMO SE LLAMA EL ID DEL PACIENTE
    @JsonIgnore
    private Patient patient ;

    public Address(){

    }

    public Address(Long id, String address, Patient patient) {
        this.id = id;
        this.address = address;
        this.patient = patient;
    }

    public Address(String address) {
        this.address = address;
    }

    public Address(String address, Patient patient) {
        this.address = address;
        this.patient = patient;
    }

    public Address(Long id, String address, String number, String city) {
        this.id = id;
        this.address = address;
        this.number = number;
        this.city = city;
    }

    public Address(String address, String number, String city) {
        this.address = address;
        this.number = number;
        this.city = city;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Patient getPatient() {
        return patient;
    }

    public void setPatient(Patient patient) {
        this.patient = patient;
    }
}
