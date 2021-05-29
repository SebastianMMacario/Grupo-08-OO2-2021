package com.Unla.TPPOO2.interfaces;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.Unla.TPPOO2.models.Persona;


@Repository
public interface IPersona extends CrudRepository<Persona, Integer> {

}

