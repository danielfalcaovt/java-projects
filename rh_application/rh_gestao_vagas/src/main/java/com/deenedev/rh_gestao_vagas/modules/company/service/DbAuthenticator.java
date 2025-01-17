package com.deenedev.rh_gestao_vagas.modules.company.service;

import java.time.Duration;
import java.time.Instant;

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
    public String auth(CompanyLoginDTO dto) throws AuthException, RuntimeException {
        Company company = this.companyRepository.findByEmail(dto.getEmail()).orElseThrow(() -> new AuthException());
        if (!this.passwordEncoder.matches(dto.getPassword(), company.password)) {
            throw new AuthException();
        }

        return JWT.create().withIssuer("company").withSubject(company.getId().toString())
                .withExpiresAt(Instant.now().plus(Duration.ofHours(8))).sign(Algorithm.HMAC256(this.secret));
    }
}
