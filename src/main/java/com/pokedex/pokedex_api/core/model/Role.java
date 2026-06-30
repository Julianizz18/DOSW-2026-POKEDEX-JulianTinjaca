package com.pokedex.pokedex_api.core.model;

/**
 * Roles del sistema. GUEST no requiere token; TRAINER y ADMIN sí.
 * Se usa también como claim del JWT (ver JwtService, capa security).
 */
public enum Role {
    GUEST,
    TRAINER,
    ADMIN
}
