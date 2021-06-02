package com.Unla.TPPOO2.interfaces;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.Unla.TPPOO2.models.PermisoDiario;

@Repository
public interface IPermisoDiario extends CrudRepository<PermisoDiario, Integer> {

}
