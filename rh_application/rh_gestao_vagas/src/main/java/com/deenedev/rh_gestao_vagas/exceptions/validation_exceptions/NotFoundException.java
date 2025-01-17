package com.deenedev.rh_gestao_vagas.exceptions.validation_exceptions;

public class NotFoundException extends RuntimeException {
    public NotFoundException(String param) {
        super(String.format("%s not found", param));
    }
}