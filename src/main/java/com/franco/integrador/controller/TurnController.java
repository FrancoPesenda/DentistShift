package com.franco.integrador.controller;

import com.franco.integrador.model.entities.Turn;
import com.franco.integrador.model.exceptions.ResourceNotFoundException;
import com.franco.integrador.model.services.TurnService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/turn")
@CrossOrigin(origins = "*", maxAge = 3600)
public class TurnController {
    @Autowired
    TurnService service ;

    @GetMapping
    public ResponseEntity<List<Turn>> getAllTurn() throws ResourceNotFoundException{

        List<Turn> listTemp = service.getAllTurn() ;

        if (listTemp != null ){
            return ResponseEntity.ok(listTemp) ;
        }else{
            throw new ResourceNotFoundException("NO SE ENCONTRO NINGUN DENTISTA") ;
        }

    }

    @PostMapping("/add")
    public ResponseEntity<Turn> save(@RequestBody Turn turn){
        return ResponseEntity.ok(service.addTurn(turn)) ;
    }

    @DeleteMapping("/{id}")
    public void deleteByID( @PathVariable Long id ){
        service.deleteByID(id);
    }

}
