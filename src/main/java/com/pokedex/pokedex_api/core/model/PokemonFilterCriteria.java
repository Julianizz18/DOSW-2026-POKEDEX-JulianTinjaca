package com.pokedex.pokedex_api.core.model;

/**
 * Criterios opcionales de filtro para el catálogo de Pokemon.
 * Cualquier campo null significa "no filtrar por esto".
 */
public record PokemonFilterCriteria(
        String type,
        String region,
        Integer generation,
        Integer minTotalStats
) {}
