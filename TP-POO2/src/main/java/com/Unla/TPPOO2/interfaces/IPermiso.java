package com.Unla.TPPOO2.interfaces;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.Unla.TPPOO2.models.Permiso;


@Repository
public interface IPermiso extends CrudRepository<Permiso, Integer> {

}
