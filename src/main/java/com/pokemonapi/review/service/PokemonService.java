package com.pokemonapi.review.service;

import com.pokemonapi.review.dto.PokemonDto;
import com.pokemonapi.review.dto.PokemonResponse;

import java.util.List;

public interface PokemonService {
    PokemonDto createPokemon(PokemonDto pokemonDto);
    PokemonResponse getAllPokemons(int pageNo, int pageSize);

    PokemonDto getPokemonById(int id);

    PokemonDto updatePokemon(PokemonDto pokemonDto, int id);

    void deletePokemonId(int id);

}
