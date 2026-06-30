package com.pokedex.pokedex_api.core.service.impl;

import com.pokedex.pokedex_api.core.exception.DuplicateResourceException;
import com.pokedex.pokedex_api.core.model.Favorite;
import com.pokedex.pokedex_api.core.port.FavoritePersistencePort;
import com.pokedex.pokedex_api.core.service.interfaces.FavoriteService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class FavoriteServiceImpl implements FavoriteService {

    private final FavoritePersistencePort favoritePort;

    @Override
    public List<Favorite> findByUserId(Long userId) {
        return favoritePort.findByUserId(userId);
    }

    @Override
    public Favorite add(Long userId, Long pokemonId) {
        if (favoritePort.existsByUserIdAndPokemonId(userId, pokemonId)) {
            throw new DuplicateResourceException("Favorite", "pokemonId", pokemonId);
        }
        Favorite favorite = Favorite.builder()
                .userId(userId)
                .pokemonId(pokemonId)
                .addedAt(LocalDateTime.now())
                .build();
        log.info("Usuario {} agrega Pokemon {} a favoritos", userId, pokemonId);
        return favoritePort.save(favorite);
    }

    @Override
    public void remove(Long userId, Long pokemonId) {
        favoritePort.deleteByUserIdAndPokemonId(userId, pokemonId);
    }
}
