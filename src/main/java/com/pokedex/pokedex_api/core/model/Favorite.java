package com.pokedex.pokedex_api.core.model;

import lombok.Builder;
import lombok.Value;

import java.time.LocalDateTime;

/**
 * Marca de un Pokemon como favorito por un usuario.
 */
@Value
@Builder(toBuilder = true)
public class Favorite {

    Long id;
    Long userId;
    Long pokemonId;
    LocalDateTime addedAt;
}
