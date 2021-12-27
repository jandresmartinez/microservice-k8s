package com.jam.liga.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class Division {

    private String nombre;
    private String id;
    private List<Equipos> equipos = new ArrayList<>();


}
