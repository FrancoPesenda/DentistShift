package com.franco.integrador.model.services;

import com.franco.integrador.model.entities.Turn;
import com.franco.integrador.model.repository.TurnRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TurnService {

    @Autowired
    TurnRepository repository ;

    public Turn addTurn( Turn turn ){ return repository.save(turn) ; }

    public List<Turn> getAllTurn(){ return repository.findAll() ; }

    public Turn getTurnByID( Long id ){ return repository.findById(id).get() ; }

    public void deleteByID( Long id ){ repository.deleteById(id);}

}
