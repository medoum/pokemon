package com.pokemonapi.review.exceptions;

public class ReviewNotFoundException extends RuntimeException {
    private static final long seriaVersionUID = 2;

    public ReviewNotFoundException(String message) {
        super(message);
    }
}
