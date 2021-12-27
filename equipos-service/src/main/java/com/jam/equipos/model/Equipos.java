package com.jam.equipos.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "equipos")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Equipos {
    @Id
    private String id;
    private String ligaId;
    private String divisionId;
    private String nombre;
    private String estadio;


}
