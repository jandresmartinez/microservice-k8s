package com.jam.liga.repository;

import com.jam.liga.model.Equipos;
import com.jam.liga.model.Liga;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface LigaRepository extends CrudRepository<Liga,String> {

    List<Equipos> findByDivisionId(String divisionId);

}
