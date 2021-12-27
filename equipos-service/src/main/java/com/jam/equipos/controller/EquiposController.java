package com.jam.equipos.controller;

import com.jam.equipos.model.Equipos;
import com.jam.equipos.repository.EquiposRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class EquiposController {

    private static final Logger LOGGER = LoggerFactory.getLogger(EquiposController.class);

    @Autowired
    EquiposRepository repository;

    @PostMapping("/")
    public Equipos add(@RequestBody Equipos equipo) {
        LOGGER.info("Equipo añadido...: {}",equipo);
        return repository.save(equipo);
    }

    @GetMapping("/{id}")
    public Equipos findById(@PathVariable("id") String id) {
        LOGGER.info("Equipo : id={}", id);
        return repository.findById(id).orElseThrow();
    }

    @GetMapping("/")
    public Iterable<Equipos> findAll() {
        LOGGER.info("Equipos");
        return repository.findAll();
    }

    @GetMapping("/division/{divisionId}")
    public List<Equipos> findByDivision(@PathVariable("divisionId") String divisionId) {
        LOGGER.info("Equipos find: divisionId={}", divisionId);
        return repository.findByDivisionId(divisionId);
    }

    @GetMapping("/liga/{ligaId}")
    public List<Equipos> findByLiga(@PathVariable("ligaId") String ligaId) {
        LOGGER.info("Equipos find: ligaId={}", ligaId);
        return repository.findByLigaId(ligaId);
    }


}
