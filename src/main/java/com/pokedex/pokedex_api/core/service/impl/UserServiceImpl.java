package com.pokedex.pokedex_api.core.service.impl;

import com.pokedex.pokedex_api.core.exception.DuplicateResourceException;
import com.pokedex.pokedex_api.core.exception.ResourceNotFoundException;
import com.pokedex.pokedex_api.core.model.Role;
import com.pokedex.pokedex_api.core.model.User;
import com.pokedex.pokedex_api.core.port.UserPersistencePort;
import com.pokedex.pokedex_api.core.service.interfaces.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class UserServiceImpl implements UserService {

    private final UserPersistencePort userPort;
    private final PasswordEncoder passwordEncoder; // Bean definido en SecurityConfig (día jueves)

    @Override
    public User findById(Long id) {
        return userPort.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("User", "id", id));
    }

    @Override
    public User findByEmail(String email) {
        return userPort.findByEmail(email)
                .orElseThrow(() -> new ResourceNotFoundException("User", "email", email));
    }

    @Override
    public User register(User user, String rawPassword) {
        if (userPort.existsByEmail(user.getEmail())) {
            throw new DuplicateResourceException("User", "email", user.getEmail());
        }
        User toCreate = user.toBuilder()
                .passwordHash(passwordEncoder.encode(rawPassword))
                .role(Role.TRAINER) // todo registro nuevo entra como TRAINER, nunca ADMIN
                .enabled(true)
                .build();
        log.info("Registrando usuario: {}", toCreate.getEmail());
        return userPort.save(toCreate);
    }

    @Override
    public User updateProfile(Long id, User user) {
        User existing = findById(id);
        User updated = existing.toBuilder()
                .username(user.getUsername())
                .build(); // email, passwordHash y role NO se actualizan por este método
        return userPort.save(updated);
    }
}
