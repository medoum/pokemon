package com.pokemonapi.review.repository;

import com.pokemonapi.review.models.Pokemon;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;



public interface PokemonRepository extends JpaRepository<Pokemon, Integer> {
    Optional<Pokemon> findByType(String type);
}