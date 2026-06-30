package com.pokedex.pokedex_api.core.model;

import lombok.Builder;
import lombok.Value;

/**
 * Perfil de entrenador. No contiene lógica de JWT ni contraseña en claro
 * (eso vive en la capa security) — solo el perfil puro.
 */
@Value
@Builder(toBuilder = true)
public class User {

    Long id;
    String email;
    String username;
    String passwordHash;   // Hash BCrypt
    Role role;
    Boolean enabled;
}
