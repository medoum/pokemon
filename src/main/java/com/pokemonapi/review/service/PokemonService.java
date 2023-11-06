package com.pokemonapi.review.service;

import com.pokemonapi.review.dto.PokemonDto;

import java.util.List;

public interface PokemonService {
    PokemonDto createPokemon(PokemonDto pokemonDto);
    List<PokemonDto> getAllPokemons();

}
