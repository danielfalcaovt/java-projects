package com.deenedev.rh_gestao_vagas.modules.applicant.services.auth;

import java.time.Duration;
import java.time.Instant;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.deenedev.rh_gestao_vagas.modules.applicant.controllers.protocols.dto.ApplicantLoginDTO;
import com.deenedev.rh_gestao_vagas.modules.applicant.models.entities.Applicant;
import com.deenedev.rh_gestao_vagas.modules.applicant.protocols.usecases.ApplicantAuthenticator;
import com.deenedev.rh_gestao_vagas.modules.applicant.repositories.ApplicantRepository;
import com.deenedev.rh_gestao_vagas.shared.protocols.dto.AuthenticatorResponse;

import jakarta.security.auth.message.AuthException;

@Service
public class DbAuthApplicant implements ApplicantAuthenticator {
    @Value("${security.applicant.secret}")
    private String secret;

    @Autowired
    private ApplicantRepository applicantRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public AuthenticatorResponse auth(ApplicantLoginDTO loginDTO) throws AuthException, RuntimeException {
        Applicant applicant = this.applicantRepository.findByEmail(loginDTO.email())
                .orElseThrow(() -> new AuthException());

        System.out.println(applicant.getPassword());
        System.out.println(loginDTO.password());

        System.out.println(passwordEncoder.matches(loginDTO.password(), applicant.getPassword()));
        if (!passwordEncoder.matches(loginDTO.password(), applicant.getPassword())) {
            throw new AuthException();
        }

        String[] roles = { "APPLICANT" };

        Instant expiresIn = Instant.now().plus(Duration.ofHours(8));
        String token = JWT.create().withIssuer("RH_GESTAO_VAGAS") // Criação + Emissor
                .withExpiresAt(expiresIn) // Expiração do token
                .withArrayClaim("roles", roles)
                .withSubject(applicant.getId().toString()) // Subject / payload do token
                .sign(Algorithm.HMAC256(this.secret)); // Algoritmo de Encriptação + Secret
        return new AuthenticatorResponse(token, expiresIn.toEpochMilli());
    }
}
