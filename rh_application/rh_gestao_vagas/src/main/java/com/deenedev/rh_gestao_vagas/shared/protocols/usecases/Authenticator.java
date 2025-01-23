package com.deenedev.rh_gestao_vagas.shared.protocols.usecases;

import jakarta.security.auth.message.AuthException;

public interface Authenticator<R, F> {
    F auth(R dto) throws AuthException, RuntimeException;
}
