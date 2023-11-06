package com.pokemonapi.review.repository;

import com.pokemonapi.review.models.Review;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ReviewRepository extends JpaRepository<Review, Integer> {
    List<Review> findbyPokemonId(int pokemonId);
}
