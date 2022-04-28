package com.franco.integrador.model.entities;

import org.springframework.data.annotation.Id;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "turns")
public class Turn {

    @Id
    @javax.persistence.Id
    @GeneratedValue( strategy = GenerationType.IDENTITY)
    private Long id ;
    @Column
    private Date date ;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "patient_id")
    private Patient patient ;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn( name = "dentist_id")
        private Dentist dentist ;

    public Patient getPatient() {
        return patient;
    }

    public Turn(){

    }

    public Turn(Long id, Date date, Patient patient, Dentist dentist) {
        this.id = id;
        this.date = date;
        this.patient = patient;
        this.dentist = dentist;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public void setPatient(Patient patient) {
        this.patient = patient;
    }

    public Dentist getDentist() {
        return dentist;
    }

    public void setDentist(Dentist dentist) {
        this.dentist = dentist;
    }
}
