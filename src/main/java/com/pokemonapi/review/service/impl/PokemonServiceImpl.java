package com.pokemonapi.review.service.impl;

import com.pokemonapi.review.dto.PokemonDto;
import com.pokemonapi.review.exceptions.PokemonNotFoundException;
import com.pokemonapi.review.models.Pokemon;
import com.pokemonapi.review.repository.PokemonRepository;
import com.pokemonapi.review.service.PokemonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PokemonServiceImpl implements PokemonService {

    private PokemonRepository pokemonRepository;

    @Autowired
    public PokemonServiceImpl(PokemonRepository pokemonRepository) {
        this.pokemonRepository = pokemonRepository;
    }

    @Override
    public PokemonDto createPokemon(PokemonDto pokemonDto) {
       Pokemon pokemon = new Pokemon();
       pokemon.setName(pokemonDto.getName());
       pokemon.setType(pokemonDto.getType());

        System.out.println(pokemon);
       Pokemon newPokemon = pokemonRepository.save(pokemon);

       PokemonDto pokemonResponse = new PokemonDto();
       pokemonResponse.setId(newPokemon.getId());
       pokemonResponse.setName(newPokemon.getName());
       pokemonResponse.setType(newPokemon.getType());
       return pokemonResponse;
    }

    @Override
    public List<PokemonDto> getAllPokemons() {
        List<Pokemon> pokemon = pokemonRepository.findAll();
        return pokemon.stream().map(p -> mapToDto(p)).collect(Collectors.toList());
    }

    @Override
    public PokemonDto getPokemonById(int id) {
        Pokemon pokemon = pokemonRepository.findById(id).orElseThrow(()-> new PokemonNotFoundException("Pokemin could not be found"));
        return mapToDto(pokemon);
    }

    @Override
    public PokemonDto updatePokemon(PokemonDto pokemonDto, int id) {
        Pokemon pokemon = pokemonRepository.findById(id).orElseThrow(()-> new PokemonNotFoundException("Pokemon could not be found"));

        pokemon.setName(pokemonDto.getName());
        pokemon.setType(pokemonDto.getType());

        Pokemon updatedPokemon = pokemonRepository.save(pokemon);
        return mapToDto(updatedPokemon);
    }

    @Override
    public void deletePokemonId(int id) {
        Pokemon pokemon = pokemonRepository.findById(id).orElseThrow(()->new PokemonNotFoundException("Pokemon could not delete"));
        pokemonRepository.delete(pokemon);
    }

    private PokemonDto mapToDto(Pokemon pokemon){
        PokemonDto pokemonDto = new PokemonDto();
        pokemonDto.setId(pokemon.getId());
        pokemonDto.setName(pokemon.getName());
        pokemonDto.setType(pokemon.getType());
        return pokemonDto;
    }

    private Pokemon mapToEntity(PokemonDto pokemonDto){
        Pokemon pokemon = new Pokemon();
        pokemon.setName(pokemon.getName());
        pokemon.setType(pokemon.getType());
        return pokemon;
    }
}
