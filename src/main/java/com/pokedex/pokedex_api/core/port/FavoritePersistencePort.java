package com.pokedex.pokedex_api.core.port;

import com.pokedex.pokedex_api.core.model.Favorite;

import java.util.List;

public interface FavoritePersistencePort {

    List<Favorite> findByUserId(Long userId);

    boolean existsByUserIdAndPokemonId(Long userId, Long pokemonId);

    Favorite save(Favorite favorite);

    void deleteByUserIdAndPokemonId(Long userId, Long pokemonId);
}
