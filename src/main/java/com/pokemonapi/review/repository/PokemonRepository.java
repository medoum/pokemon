package com.pokemonapi.review.repository;

import com.pokemonapi.review.models.Pokemon;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PokemonRepository extends JpaRepository<Pokemon, Integer> {

}
