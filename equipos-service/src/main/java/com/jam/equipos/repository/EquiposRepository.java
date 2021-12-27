package com.jam.equipos.repository;

import com.jam.equipos.model.Equipos;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface EquiposRepository extends CrudRepository<Equipos,String> {
    List<Equipos> findByNombre(String nombre);
    List<Equipos> findByLigaId(String ligaId);
    List<Equipos> findByDivisionId(String divisionId);

}
