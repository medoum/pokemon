package com.pokemonapi.review.controllers;

import com.pokemonapi.review.dto.PokemonDto;
import com.pokemonapi.review.models.Pokemon;
import com.pokemonapi.review.service.PokemonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/")
public class PokemonController {
    private PokemonService pokemonService;

    @Autowired
    public PokemonController(PokemonService pokemonService) {
        this.pokemonService = pokemonService;
    }

    @GetMapping("pokemon")
    public ResponseEntity<List<PokemonDto>> getPokemons(){
        return new ResponseEntity<>(pokemonService.getAllPokemons(), HttpStatus.OK);
    }
    @GetMapping("pokemon/{id}")
    public Pokemon pokemonDeatil(@PathVariable int id){
        return new Pokemon(id, "squirtle","water");
    }
    @PostMapping("pokemon/create")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public ResponseEntity<PokemonDto> createPokemon(@RequestBody PokemonDto pokemonDto){
      return new ResponseEntity<>(pokemonService.createPokemon(pokemonDto), HttpStatus.CREATED);
    }
    @PutMapping("pokemon/{id}/update")
    public ResponseEntity<Pokemon> updatePokemon(@RequestBody Pokemon pokemon, @PathVariable("id") int pokemonId){
        System.out.println(pokemon.getName());
        System.out.println(pokemon.getType());
        return ResponseEntity.ok(pokemon);
    }
    @DeleteMapping("pokemon/{id}/delete")
    public ResponseEntity<String> deletePokemon(@PathVariable("id") int pokemonId){
        System.out.println(pokemonId);
        return ResponseEntity.ok("pokemon deleted successfully");

    }
}
