package com.pokemonapi.review.dto;

import lombok.Data;

@Data
public class AuthResponseDto {
    private String accestoken;
    private String tokenType = "Bearer ";

    public AuthResponseDto(String accestoken){
        this.accestoken = accestoken;
    }
}
