package com.deenedev.rh_gestao_vagas.exceptions;

public class EmailAlreadyExistsException extends RuntimeException {
    public EmailAlreadyExistsException() {
        super("Este usuário já existe.");
    }
}
