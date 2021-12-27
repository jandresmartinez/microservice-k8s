package com.jam.liga.controller;

import com.jam.liga.client.DivisionClient;
import com.jam.liga.client.EquiposClient;
import com.jam.liga.model.Equipos;
import com.jam.liga.model.Liga;
import com.jam.liga.repository.LigaRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class LigaController {

    private static final Logger LOGGER = LoggerFactory.getLogger(LigaController.class);

    @Autowired
    LigaRepository repository;

    @Autowired
    DivisionClient divisionClient;

    @Autowired
    EquiposClient equiposClient;

    @PostMapping("/")
    public Liga add(@RequestBody Liga liga) {
        LOGGER.info("Liga añadida...: {}",liga);
        return repository.save(liga);
    }

    @GetMapping("/{id}")
    public Liga findById(@PathVariable("id") String id) {
        LOGGER.info("Liga : id={}", id);
        return repository.findById(id).orElseThrow();
    }

    @GetMapping("/")
    public Iterable<Liga> findAll() {
        LOGGER.info("Liga");
        return repository.findAll();
    }

    @GetMapping("/division/{divisionId}")
    public List<Equipos> findByDepartment(@PathVariable("divisionId") String divisionId) {
        LOGGER.info("Equipos find: divisionId={}", divisionId);
        return repository.findByDivisionId(divisionId);
    }

    @GetMapping("/{id}/with-division")
    public Liga findByIdWithDivision(@PathVariable("id") String id) {
        LOGGER.info("Liga find: id={}", id);
        Liga liga = repository.findById(id).orElseThrow();
        liga.setDivision(divisionClient.findByLiga(liga.getId()));
        return liga;
    }

    @GetMapping("/{id}/with-equipos")
    public Liga findByIdWithEquipos(@PathVariable("id") String id) {
        LOGGER.info("Liga find: id={}", id);
        Liga liga = repository.findById(id).orElseThrow();
        liga.setEquipos(equiposClient.findByLiga(liga.getId()));
        return liga;
    }
}
