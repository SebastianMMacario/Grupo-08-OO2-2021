package com.Unla.TPPOO2.interfaces;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.Unla.TPPOO2.models.Lugar;

@Repository
public interface ILugar extends CrudRepository<Lugar, Integer>{

}
