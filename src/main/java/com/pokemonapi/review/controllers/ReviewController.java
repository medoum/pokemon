package com.pokemonapi.review.controllers;

import com.pokemonapi.review.dto.ReviewDto;
import com.pokemonapi.review.service.ReviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class ReviewController {

    private ReviewService reviewService;

    @Autowired
    public ReviewController(ReviewService reviewService){
        this.reviewService = reviewService;
    }
    @PostMapping("/pokemon/{pokemonId}/review")
    public ResponseEntity<ReviewDto> createReview(@PathVariable(value ="pokemonId") int pokemonId, @RequestBody ReviewDto reviewDto){
        return new ResponseEntity<>(reviewService.createReview(pokemonId, reviewDto), HttpStatus.CREATED);
    }
    @GetMapping("/pokemon/{pokemonId}/reviews")
    public List<ReviewDto> getReviewByPokemonId(@PathVariable(value = "pokemonId") int pokemonId){
        return reviewService.getReviewByPokemonId(pokemonId);
    }
    @GetMapping("/pokemon/{pokemonId}/reviews/{id}")
    public ResponseEntity<ReviewDto> getReviewId(@PathVariable(value = "pokemonId") int pokemonId, @PathVariable(value = "id") int reviewId) {

        ReviewDto reviewDto = reviewService.getReviewId(pokemonId, reviewId);
        return new ResponseEntity<>(reviewDto, HttpStatus.OK);
    }
    @PutMapping("/pokemon/{pokemonId}/reviews/{id}")
    public ResponseEntity<ReviewDto> updateReview(@PathVariable(value = "pokemonId") int pokemonId, @PathVariable(value = "id") int reviewId, @RequestBody ReviewDto reviewDto){

        ReviewDto updatedReview = reviewService.updateReview(pokemonId, reviewId, reviewDto);
        return new ResponseEntity<>(updatedReview, HttpStatus.OK);
    }
    @DeleteMapping("/pokemon/{pokemonId}/reviews/{id}")
    public ResponseEntity<String> deleteReview(@PathVariable(value = "pokemonId") int pokemonId, @PathVariable(value = "id") int reviewId){
        reviewService.deleteReview(pokemonId, reviewId);

        return new ResponseEntity<>("Review deleted successfully", HttpStatus.OK);
    }
}
