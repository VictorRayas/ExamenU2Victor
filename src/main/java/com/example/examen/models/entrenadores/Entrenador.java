package com.example.examen.models.entrenadores;

import com.example.examen.models.pokemon.Pokemon;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "entrenadores")
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class Entrenador {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(nullable = false, unique = true, length = 50)
    private String nombreEntrenador;
    @Column(nullable = false, unique = true, length = 50)
    private String equipo;
    @OneToMany(mappedBy = "entrenador")
    @JsonIgnore
    private List<Pokemon> pokemons;
}
