package com.example.examen.models.pokemon;

import com.example.examen.models.entrenadores.Entrenador;
import jdk.jfr.Category;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "pokemons")
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class Pokemon {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(nullable = false, unique = true, length = 50)
    private  String nombre;
    @Column(nullable = false, unique = true, length = 50)
    private  String tipo;

    private  int nivel;

    private  int salud;

    private  int ataque;
    @ManyToOne()
    @JoinColumn(name = "entrenador_id", nullable = false)
    private Entrenador entrenador;


}
