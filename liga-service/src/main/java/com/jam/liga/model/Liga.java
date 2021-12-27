package com.jam.liga.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.ArrayList;
import java.util.List;

@Document(collection = "liga")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Liga {
    @Id
    private String id;
    private List<Equipos> equipos = new ArrayList<>();
    private List<Division> division = new ArrayList<>();
    private String nombre;



}
