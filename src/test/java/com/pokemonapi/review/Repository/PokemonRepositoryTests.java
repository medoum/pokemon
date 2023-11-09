package com.pokemonapi.review.Repository;

import com.pokemonapi.review.models.Pokemon;
import com.pokemonapi.review.repository.PokemonRepository;
import org.assertj.core.api.Assertions;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.jdbc.EmbeddedDatabaseConnection;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

@DataJpaTest
@AutoConfigureTestDatabase(connection = EmbeddedDatabaseConnection.H2)
public class PokemonRepositoryTests {

    @Autowired
    private PokemonRepository pokemonRepository;

    @Test
    public void PokemonRepository_SaveAll_ReturnSavedPokemon() {

        //Arrange
        Pokemon pokemon = Pokemon.builder()
                .name("pikachu")
                .type("electric").build();

        //Act
        Pokemon savedPokemon = pokemonRepository.save(pokemon);

        //Assert
        Assertions.assertThat(savedPokemon).isNotNull();
        Assertions.assertThat(savedPokemon.getId()).isGreaterThan(0);
    }
}
