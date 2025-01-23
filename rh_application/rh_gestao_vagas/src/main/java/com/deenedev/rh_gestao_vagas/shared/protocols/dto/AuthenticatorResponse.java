package com.deenedev.rh_gestao_vagas.shared.protocols.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class AuthenticatorResponse {
    public String token;
    public Long expiresIn;
}
