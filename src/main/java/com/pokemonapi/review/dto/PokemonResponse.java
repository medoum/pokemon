package com.pokemonapi.review.dto;

import lombok.Data;

import java.util.List;

@Data
public class PokemonResponse {
    private List<PokemonDto> content;
    private int pageNo;
    private int pagaSize;
    private long totalElements;
    private int totalPages;

    private boolean last;

}
