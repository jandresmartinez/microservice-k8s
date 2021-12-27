package com.jam.division.controller;

import com.jam.division.client.EquiposClient;
import com.jam.division.model.Division;
import com.jam.division.model.Equipos;
import com.jam.division.repository.DivisionRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class DivisionController {

    private static final Logger LOGGER = LoggerFactory.getLogger(DivisionController.class);

    @Autowired
    DivisionRepository repository;
    @Autowired
    EquiposClient equiposClient;


    @PostMapping("/")
    public Division add(@RequestBody Division division) {
        LOGGER.info("Division añadida en el controller...: {}",division);
        return repository.save(division);
    }

    @GetMapping("/{id}")
    public Division findById(@PathVariable("id") String id) {
        LOGGER.info("Division : id={}", id);
        return repository.findById(id).orElseThrow();
    }

    @GetMapping("/")
    public Iterable<Division> findAll() {
        LOGGER.info("Division");
        return repository.findAll();
    }

    @GetMapping("/liga/{ligaId}")
    public List<Division> findByLiga(@PathVariable("ligaId") String ligaId) {
        LOGGER.info("Equipos find: ligaId={}", ligaId);
        return repository.findByLigaId(ligaId);
    }
}
