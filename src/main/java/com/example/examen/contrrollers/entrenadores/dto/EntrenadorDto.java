package com.example.examen.contrrollers.entrenadores.dto;

import com.example.examen.models.entrenadores.Entrenador;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class EntrenadorDto {
    private int id;
    private String nombreEntrenador;
    private String equipo;
    public Entrenador getEntrenador() {
        return new Entrenador(
                getId(), getNombreEntrenador(), getEquipo(), null
        );
    }
}
