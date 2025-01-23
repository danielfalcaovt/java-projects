package com.deenedev.rh_gestao_vagas.modules.company.service;

import java.time.Duration;
import java.time.Instant;
import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.deenedev.rh_gestao_vagas.modules.company.controllers.protocols.dto.CompanyLoginDTO;
import com.deenedev.rh_gestao_vagas.modules.company.models.entities.Company;
import com.deenedev.rh_gestao_vagas.modules.company.protocols.usecases.CompanyAuthenticator;
import com.deenedev.rh_gestao_vagas.modules.company.repositories.CompanyRepository;
import com.deenedev.rh_gestao_vagas.shared.protocols.dto.AuthenticatorResponse;

import jakarta.security.auth.message.AuthException;

@Service
public class DbAuthenticator implements CompanyAuthenticator {
    @Value("${security.company.secret}")
    private String secret;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private CompanyRepository companyRepository;

    @Override
    public AuthenticatorResponse auth(CompanyLoginDTO dto) throws AuthException, RuntimeException {
        Company company = this.companyRepository.findByEmail(dto.email()).orElseThrow(() -> new AuthException());
        if (!this.passwordEncoder.matches(dto.password(), company.getPassword())) {
            throw new AuthException();
        }
        
        Instant expiresIn = Instant.now().plus(Duration.ofHours(8));
        String[] roles = { "COMPANY" };
        String token = JWT.create()
                .withIssuer("company")
                .withArrayClaim("roles", roles)
                .withSubject(company.getId().toString())
                .withExpiresAt(expiresIn)
                .sign(Algorithm.HMAC256(this.secret));

        return new AuthenticatorResponse(token, expiresIn.toEpochMilli());
    }
}
