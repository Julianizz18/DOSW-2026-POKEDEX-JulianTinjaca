package com.pokedex.pokedex_api.core.exception;

import lombok.Getter;

/**
 * Excepción base de negocio. Lleva un errorCode que el GlobalExceptionHandler
 * (capa controller, día miércoles) usa para construir el ApiError sin acoplarse
 * al tipo concreto de excepción.
 */
@Getter
public class BusinessException extends RuntimeException {

    private final String errorCode;

    public BusinessException(String message, String errorCode) {
        super(message);
        this.errorCode = errorCode;
    }
}
