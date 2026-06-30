package com.pokedex.pokedex_api.core.service.impl;

import com.pokedex.pokedex_api.core.exception.ResourceNotFoundException;
import com.pokedex.pokedex_api.core.model.Team;
import com.pokedex.pokedex_api.core.port.TeamPersistencePort;
import com.pokedex.pokedex_api.core.service.interfaces.TeamService;
import com.pokedex.pokedex_api.core.validator.TeamValidator;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class TeamServiceImpl implements TeamService {

    private final TeamPersistencePort teamPort;
    private final TeamValidator teamValidator;

    @Override
    public List<Team> findByUserId(Long userId) {
        return teamPort.findByUserId(userId);
    }

    @Override
    public Team findById(Long id) {
        return teamPort.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Team", "id", id));
    }

    @Override
    public Team create(Team team) {
        Team toCreate = team.toBuilder()
                .pokemonIds(team.getPokemonIds() == null ? new ArrayList<>() : team.getPokemonIds())
                .build();
        log.info("Creando equipo '{}' para usuario {}", toCreate.getName(), toCreate.getUserId());
        return teamPort.save(toCreate);
    }

    @Override
    public Team addPokemon(Long teamId, Long pokemonId) {
        Team team = findById(teamId);
        teamValidator.validateCanAddPokemon(team);
        teamValidator.validateNotDuplicate(team, pokemonId);

        List<Long> updatedIds = new ArrayList<>(team.getPokemonIds());
        updatedIds.add(pokemonId);

        Team updated = team.toBuilder().pokemonIds(updatedIds).build();
        return teamPort.save(updated);
    }

    @Override
    public Team removePokemon(Long teamId, Long pokemonId) {
        Team team = findById(teamId);
        List<Long> updatedIds = new ArrayList<>(team.getPokemonIds());
        updatedIds.remove(pokemonId);

        Team updated = team.toBuilder().pokemonIds(updatedIds).build();
        return teamPort.save(updated);
    }

    @Override
    public void delete(Long id) {
        findById(id);
        teamPort.deleteById(id);
    }
}
