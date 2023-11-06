package com.pokemonapi.review.service;

import com.pokemonapi.review.dto.ReviewDto;
import com.pokemonapi.review.models.Review;

import java.util.List;

public interface ReviewService {
    ReviewDto createReview(int pokemonId, ReviewDto reviewDto);
    List<ReviewDto> getReviewByPokemonId(int id);

}