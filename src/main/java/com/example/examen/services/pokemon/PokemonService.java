package com.example.examen.services.pokemon;

import com.example.examen.models.pokemon.Pokemon;
import com.example.examen.models.pokemon.PokemonRepository;
import com.example.examen.utils.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

@Service
@Transactional

public class PokemonService {
    @Autowired
private PokemonRepository repository;
    @Transactional(readOnly = true)
    public Response<List<Pokemon>> getAll(){
        return new Response<>(
                this.repository.findAll(),
                false,
                200,
                "OK"
        );
    }

    @Transactional(readOnly = true)
    public Response<Pokemon>getOne(Long id){
        if (this.repository.existsById(id)){
            return new Response<>(
                    this.repository.findById(id).get(),
                    false,
                    200,
                    "OK"
            );
        }
        return new Response<>(
                null,
                true,
                400,
                "Pokemon no encontrada"
        );
    }
    @Transactional(rollbackFor = {SQLException.class})
    public Response<Pokemon> insert(Pokemon pokemon){
        Optional<Pokemon> exists=this.repository.findByNombre(pokemon.getNombre());
        if (exists.isPresent())
            return new Response<>(
                    null,
                    true,
                    400,
                    "POkemon ya se encuentra registrada"
            );
        return new Response<>(
                this.repository.saveAndFlush(pokemon),
                false,
                200,
                "POkemon registrada"
        );

    }
    @Transactional(rollbackFor = {SQLException.class})
    public Response<Pokemon> update(Pokemon pokemon, long id){
        if (!this.repository.existsById(pokemon.getId()))
            return new Response<>(
                    null,
                    true,
                    400,
                    "POkemon no se encontr??"
            );
        return new Response<>(
                this.repository.saveAndFlush(pokemon),
                false,
                200,
                "Pokemon actualizado correctamente"
        );

    }

    @Transactional(rollbackFor = {SQLException.class})
    public Response<Pokemon> delete( Long id){
        Response response = null;
        if (this.repository.existsById(id))
        {
            this.repository.deleteById(id);
            response= new Response(this.repository.findById(id), false,200,"Entrenador Eliminado ");
        }else{
            response=  new Response<>(
                    null,
                    true,
                    400,
                    "POkemon no se encontr??"
            );
        }
        return  response;



    }






}
