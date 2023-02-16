package com.example.examen.contrrollers.pokemon.dto;

import com.example.examen.models.entrenadores.Entrenador;
import com.example.examen.models.pokemon.Pokemon;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class PokemonDto {
    private long id;
    private  String nombre;
    private  String tipo;
    private  int nivel;
    private  int salud;
    private  int ataque;
    private  Entrenador entrenador;

    public Pokemon getPokemon(){
        return new Pokemon(
                getId(),
                getNombre(),
                getTipo(),
                getNivel(),
                getSalud(),
                getAtaque(),
                getEntrenador()
        );
    }

}
