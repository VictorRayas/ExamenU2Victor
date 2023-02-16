package com.example.examen.contrrollers.pokemon;

import com.example.examen.contrrollers.pokemon.dto.PokemonDto;
import com.example.examen.models.pokemon.Pokemon;
import com.example.examen.services.pokemon.PokemonService;
import com.example.examen.utils.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api-examen/pokemon")
@CrossOrigin(origins = {"*"})
public class PokemonController {
    @Autowired
    private PokemonService service;
    @GetMapping("/")
    public ResponseEntity<Response<List<Pokemon>>> getAll(){
        return new ResponseEntity<>(
                this.service.getAll(),
                HttpStatus.OK
        );
    }
    @GetMapping("/{id}")
    public ResponseEntity<Response<Pokemon>>getOne(@PathVariable long id ){
        return new ResponseEntity<>(
                this.service.getOne(id),
                HttpStatus.OK
        );
    }

    @PostMapping("/")
    public ResponseEntity<Response<Pokemon>>insert(
            @RequestBody PokemonDto pokemon
    ){
        return new ResponseEntity<>(
                this.service.insert(pokemon.getPokemon()),
                HttpStatus.CREATED
        );
    }
    @PutMapping("/{id}")
    public ResponseEntity<Response<Pokemon>>update(@PathVariable long id,@RequestBody PokemonDto pokemon){
        return new ResponseEntity<>(
                this.service.update(pokemon.getPokemon(),id),
                HttpStatus.CREATED
        );
    }
    @DeleteMapping("/{id}")
    public  ResponseEntity<Response<Pokemon>>
    delete(@PathVariable Long id){
        return new ResponseEntity<>(this.service.delete(id),HttpStatus.OK);

    }


}
