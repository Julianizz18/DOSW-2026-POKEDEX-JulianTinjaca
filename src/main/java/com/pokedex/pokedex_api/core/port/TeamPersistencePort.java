package com.pokedex.pokedex_api.core.port;

import com.pokedex.pokedex_api.core.model.Team;

import java.util.List;
import java.util.Optional;

public interface TeamPersistencePort {

    Optional<Team> findById(Long id);

    List<Team> findByUserId(Long userId);

    Team save(Team team);

    void deleteById(Long id);
}
