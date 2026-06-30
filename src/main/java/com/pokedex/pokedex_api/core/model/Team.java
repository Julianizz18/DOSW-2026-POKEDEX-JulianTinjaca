package com.pokedex.pokedex_api.core.model;

import lombok.Builder;
import lombok.Value;

import java.util.List;

/**
 * Equipo Pokemon de un entrenador. Un usuario puede tener 1..N equipos,
 * cada uno con hasta 6 Pokemon (regla validada en TeamValidator, no aquí:
 * el modelo solo representa el dato, la regla de negocio vive aparte).
 */
@Value
@Builder(toBuilder = true)
public class Team {

    Long id;
    Long userId;
    String name;
    List<Long> pokemonIds;
}
