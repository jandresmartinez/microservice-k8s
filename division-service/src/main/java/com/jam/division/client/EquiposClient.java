package com.jam.division.client;

import com.jam.division.model.Equipos;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;
@FeignClient(name = "equipos")
public interface EquiposClient {

    @GetMapping("/division/{divisionId}")
    List<Equipos> findByDivision(@PathVariable("divisionId") String divisionId);


}
