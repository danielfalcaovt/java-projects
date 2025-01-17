package com.deenedev.rh_gestao_vagas.modules.applicant.services.auth;

import java.time.Duration;
import java.time.Instant;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.deenedev.rh_gestao_vagas.modules.applicant.models.entities.Applicant;
import com.deenedev.rh_gestao_vagas.modules.applicant.protocols.dto.ApplicantLoginDTO;
import com.deenedev.rh_gestao_vagas.modules.applicant.protocols.usecases.ApplicantAuthenticator;
import com.deenedev.rh_gestao_vagas.modules.applicant.repositories.ApplicantRepository;

import jakarta.security.auth.message.AuthException;

@Service
public class DbAuthApplicant implements ApplicantAuthenticator {
    @Value("${security.applicant.secret}")
    private String secret;

    @Autowired
    private ApplicantRepository applicantRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;
    
    public String auth(ApplicantLoginDTO applicantAuthDTO) throws AuthException, RuntimeException {
        Applicant applicant = this.applicantRepository.findByEmail(applicantAuthDTO.getEmail()).orElseThrow(() -> new AuthException());

        if (!passwordEncoder.matches(applicantAuthDTO.getPassword(), applicant.getPassword())) {
            throw new AuthException();
        }

        return JWT.create().withIssuer("RH_GESTAO_VAGAS")               // Criação + Emissor
                .withExpiresAt(Instant.now().plus(Duration.ofHours(8))) // Expiração do token
                .withSubject(applicant.getId().toString())              // Subject / payload do token
                .sign(Algorithm.HMAC256(this.secret));                  // Algoritmo de Encriptação + Secret
    }
}
