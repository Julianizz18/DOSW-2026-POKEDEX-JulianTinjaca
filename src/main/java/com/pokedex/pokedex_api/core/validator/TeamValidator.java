package com.pokedex.pokedex_api.core.validator;

import com.pokedex.pokedex_api.core.exception.InvalidOperationException;
import com.pokedex.pokedex_api.core.model.Team;
import org.springframework.stereotype.Component;

/**
 * Reglas de negocio de Team que no dependen de infraestructura,
 * por eso viven en core/validator y no en el servicio directamente:
 * así se pueden probar de forma aislada y reutilizar si otro servicio
 * también necesita validar un equipo.
 */
@Component
public class TeamValidator {

    private static final int MAX_POKEMON_PER_TEAM = 6;

    public void validateCanAddPokemon(Team team) {
        if (team.getPokemonIds() != null && team.getPokemonIds().size() >= MAX_POKEMON_PER_TEAM) {
            throw new InvalidOperationException(
                    "El equipo '" + team.getName() + "' ya tiene el máximo de "
                            + MAX_POKEMON_PER_TEAM + " Pokémon permitidos");
        }
    }

    public void validateNotDuplicate(Team team, Long pokemonId) {
        if (team.getPokemonIds() != null && team.getPokemonIds().contains(pokemonId)) {
            throw new InvalidOperationException(
                    "El Pokémon con id=" + pokemonId + " ya está en el equipo '" + team.getName() + "'");
        }
    }
}
