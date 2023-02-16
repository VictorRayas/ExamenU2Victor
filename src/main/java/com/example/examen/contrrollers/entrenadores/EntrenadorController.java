package com.example.examen.contrrollers.entrenadores;

import com.example.examen.contrrollers.entrenadores.dto.EntrenadorDto;
import com.example.examen.contrrollers.pokemon.dto.PokemonDto;
import com.example.examen.models.entrenadores.Entrenador;
import com.example.examen.models.pokemon.Pokemon;
import com.example.examen.services.entrenadores.EntrenadorSerivce;
import com.example.examen.services.pokemon.PokemonService;
import com.example.examen.utils.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api-examen/entrenador")
@CrossOrigin(origins = {"*"})
public class EntrenadorController {
    @Autowired
    private EntrenadorSerivce service;
    @GetMapping("/")
    public ResponseEntity<Response<List<Entrenador>>> getAll(){
        return new ResponseEntity<>(
                this.service.getAll(),
                HttpStatus.OK
        );
    }
    @GetMapping("/{id}")
    public ResponseEntity<Response<Entrenador>>getOne(@PathVariable long id ){
        return new ResponseEntity<>(
                this.service.getOne(id),
                HttpStatus.OK
        );
    }

    @PostMapping("/")
    public ResponseEntity<Response<Entrenador>>insert(
            @RequestBody EntrenadorDto entrenador
    ){
        return new ResponseEntity<>(
                this.service.insert(entrenador.getEntrenador()),
                HttpStatus.CREATED
        );
    }
    @PutMapping("/{id}")
    public ResponseEntity<Response<Entrenador>>update(@RequestBody EntrenadorDto entrenador){
        return new ResponseEntity<>(
                this.service.update(entrenador.getEntrenador()),
                HttpStatus.CREATED
        );
    }

    @DeleteMapping("/{id}")
    public  ResponseEntity<Response<Entrenador>>
    delete(@PathVariable Long id){
        return new ResponseEntity<>(this.service.delete(id),HttpStatus.OK);

    }

}
