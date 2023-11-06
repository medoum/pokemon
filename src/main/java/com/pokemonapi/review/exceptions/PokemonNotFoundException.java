package com.pokemonapi.review.exceptions;

public class PokemonNotFoundException extends RuntimeException{
    private static final long seriaVersionUID = 1;

    public PokemonNotFoundException(String message){
        super(message);
    }
}
