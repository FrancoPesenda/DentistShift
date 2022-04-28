package com.franco.integrador.model.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.springframework.data.annotation.Id;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table( name = "dentists")
public class Dentist {
    @Id
    @javax.persistence.Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id ;
    @Column
    private String name ;
    @Column
    private String lastName ;
    @Column(unique = true , nullable = false)
    private String registration ;
    @OneToMany(mappedBy = "dentist" , fetch = FetchType.EAGER)
    @JsonIgnore
    private Set<Turn> turnSet ;

    public Dentist(){

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

    public Dentist(Long id, String name, String lastName, String registration, Set<Turn> turnSet) {
        this.id = id;
        this.name = name;
        this.lastName = lastName;
        this.registration = registration;
        this.turnSet = turnSet;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getRegistration() {
        return registration;
    }

    public void setRegistration(String registration) {
        this.registration = registration;
    }

    public Set<Turn> getTurnSet() {
        return turnSet;
    }

    public void setTurnSet(Set<Turn> turnSet) {
        this.turnSet = turnSet;
    }
}
