package com.jam.liga.client;

import com.jam.liga.model.Equipos;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient(name = "equipos")
public interface EquiposClient {

    @GetMapping("/liga/{ligaId}")
    List<Equipos> findByLiga(@PathVariable("ligaId") String ligaId);


}
