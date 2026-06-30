package com.pokedex.pokedex_api.core.model;

import lombok.Builder;
import lombok.Value;

import java.util.List;

/**
 * Entidad de negocio Pokemon. SIN anotaciones JPA — este objeto no sabe
 * que existe una base de datos. @Value = inmutable. toBuilder() permite
 * crear copias modificadas sin mutar el original:
 *
 *   Pokemon actualizado = pikachu.toBuilder().name("Raichu").build();
 */
@Value
@Builder(toBuilder = true)
public class Pokemon {

    Long id;
    Integer nationalNumber;
    String name;
    String description;
    String imageUrl;
    List<String> types;
    String region;
    Integer generation;
    Boolean hasMega;
    PokemonStats stats;
}
