package com.jam.division.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.ArrayList;
import java.util.List;

@Document(collection = "division")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Division {

    @Id
    private String id;
    private String nombre;
    private String ligaId;
    @Transient
    private List<Equipos> equipos = new ArrayList<>();


    public Division(String nombre, String ligaId){
        this.nombre = nombre;
        this.ligaId = ligaId;
    }


}
