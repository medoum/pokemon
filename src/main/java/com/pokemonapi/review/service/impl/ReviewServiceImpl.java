package com.pokemonapi.review.service.impl;

import com.pokemonapi.review.dto.ReviewDto;
import com.pokemonapi.review.exceptions.PokemonNotFoundException;
import com.pokemonapi.review.models.Pokemon;
import com.pokemonapi.review.models.Review;
import com.pokemonapi.review.repository.PokemonRepository;
import com.pokemonapi.review.repository.ReviewRepository;
import com.pokemonapi.review.service.ReviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ReviewServiceImpl implements ReviewService {

    private ReviewRepository reviewRepository;
    private PokemonRepository pokemonRepository;

    @Autowired
    private ReviewServiceImpl(ReviewRepository reviewRepository, PokemonRepository pokemonRepository){
        this.reviewRepository = reviewRepository;
        this.pokemonRepository = pokemonRepository;
    }
    @Override
    public ReviewDto createReview(int pokemonId, ReviewDto reviewDto) {
        Review review = mapToEntity(reviewDto);

        Pokemon pokemon = pokemonRepository.findById(pokemonId).orElseThrow(()->new PokemonNotFoundException("Pokemon with assciated review not found"));

        review.setPokemon(pokemon);

        Review newReview = reviewRepository.save(review);

        return matToDto(newReview);
    }

    @Override
    public List<ReviewDto> getReviewByPokemonId(int id) {
        List<Review> reviews = reviewRepository.findbyPokemonId(id);

        return reviews.stream().map(review -> matToDto(review)).collect(Collectors.toList());
    }
    private ReviewDto matToDto(Review review){
        ReviewDto reviewDto = new ReviewDto();
        reviewDto.setId(review.getId());
        reviewDto.setTitle(review.getTitle());
        reviewDto.setContent(review.getContent());
        reviewDto.setStars(review.getStars());
        return reviewDto;
    }

    private Review mapToEntity(ReviewDto reviewDto){
        Review review = new Review();

        review.setId(review.getId());
        review.setTitle(review.getTitle());
        review.setContent(review.getContent());
        review.setStars(review.getStars());
        return review;
    }
}