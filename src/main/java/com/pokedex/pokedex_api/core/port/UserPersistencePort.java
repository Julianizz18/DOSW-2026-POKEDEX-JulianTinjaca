package com.pokedex.pokedex_api.core.port;

import com.pokedex.pokedex_api.core.model.User;

import java.util.Optional;

public interface UserPersistencePort {

    Optional<User> findById(Long id);

    Optional<User> findByEmail(String email);

    boolean existsByEmail(String email);

    User save(User user);
}
