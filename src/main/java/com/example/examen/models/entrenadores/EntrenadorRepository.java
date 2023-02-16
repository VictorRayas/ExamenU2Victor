package com.example.examen.models.entrenadores;

import com.example.examen.models.pokemon.Pokemon;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
@Repository
public interface EntrenadorRepository extends JpaRepository<Entrenador, Long> {
    Optional<Entrenador> findById(Long id);
    Optional<Entrenador>findByNombreEntrenador(String nombreEntrenador);
}
