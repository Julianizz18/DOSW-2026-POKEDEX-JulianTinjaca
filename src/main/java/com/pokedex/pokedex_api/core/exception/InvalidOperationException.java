package com.pokedex.pokedex_api.core.exception;

/**
 * Se lanza cuando una operación viola una regla de negocio que no es
 * ni "no encontrado" ni "duplicado" — ej. intentar agregar un 7mo
 * Pokemon a un equipo.
 */
public class InvalidOperationException extends BusinessException {

    public InvalidOperationException(String message) {
        super(message, "INVALID_OPERATION");
    }
}
