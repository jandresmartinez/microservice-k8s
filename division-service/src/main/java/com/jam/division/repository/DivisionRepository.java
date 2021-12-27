package com.jam.division.repository;

import com.jam.division.model.Division;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface DivisionRepository extends CrudRepository<Division,String> {
    List<Division> findByNombre(String nombre);
    List<Division> findByLigaId(String ligaId);


}
