package com.pokedex.pokedex_api.core.service.interfaces;

import com.pokedex.pokedex_api.core.model.User;

public interface UserService {

    User findById(Long id);

    User findByEmail(String email);

    User register(User user, String rawPassword);

    User updateProfile(Long id, User user);
}
