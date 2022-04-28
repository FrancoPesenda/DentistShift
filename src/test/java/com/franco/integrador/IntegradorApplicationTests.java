package com.franco.integrador;

import com.franco.integrador.model.entities.Dentist;
import com.franco.integrador.model.entities.Patient;
import com.franco.integrador.model.entities.Turn;
import com.franco.integrador.model.services.DentistService;
import com.franco.integrador.model.services.PatientService;
import com.franco.integrador.model.services.TurnService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Date;
import java.util.Optional;

@SpringBootTest
class IntegradorApplicationTests {
	@Autowired
	DentistService dentistService;
	@Autowired
	PatientService patientService;
	@Autowired
	TurnService turnService ;

	@Test
	void dentistAdd() {
		dentistService.addDentist(new Dentist(1L,"Franco","Pesenda","AAA111", null));
		Dentist dentist = dentistService.getDentistByID(1L);
		Assertions.assertEquals("Pesenda",dentist.getLastName());
	}

	@Test
	void patientAdd(){
		patientService.addPatient(new Patient(1L,"Franco","Pesenda",null,null,null));
		Patient patient = patientService.getPatientByID(1L);
		Assertions.assertEquals("Pesenda" , patient.getLastName());
	}

	@Test
	void turnAdd(){
		turnService.addTurn(new Turn(1L,null,null,null)) ;
		Turn turn = turnService.getTurnByID(1L) ;
		Assertions.assertEquals(null,turn.getDate());
	}


}
