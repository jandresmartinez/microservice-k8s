package com.jam.liga.client;

import com.jam.liga.model.Division;
import com.jam.liga.model.Equipos;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient(name = "division")
public interface DivisionClient {

    @GetMapping("/liga/{ligaId}")
    List<Division> findByLiga(@PathVariable("ligaId") String ligaId);


}
