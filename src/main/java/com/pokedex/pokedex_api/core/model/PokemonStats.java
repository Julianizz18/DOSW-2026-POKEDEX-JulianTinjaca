package com.pokedex.pokedex_api.core.model;

import lombok.Builder;
import lombok.Value;

/**
 * Stats de un Pokemon. Inmutable — el total se calcula, no se persiste
 * como campo aparte para evitar inconsistencias.
 */
@Value
@Builder
public class PokemonStats {

    Integer hp;
    Integer attack;
    Integer defense;
    Integer specialAttack;
    Integer specialDefense;
    Integer speed;

    public Integer getTotal() {
        return hp + attack + defense + specialAttack + specialDefense + speed;
    }
}
