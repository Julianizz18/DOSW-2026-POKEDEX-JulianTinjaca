package com.pokedex.pokedex_api.core.service.interfaces;

import com.pokedex.pokedex_api.core.model.Favorite;

import java.util.List;

public interface FavoriteService {

    List<Favorite> findByUserId(Long userId);

    Favorite add(Long userId, Long pokemonId);

    void remove(Long userId, Long pokemonId);
}
