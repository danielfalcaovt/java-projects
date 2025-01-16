package com.deenedev.rh_gestao_vagas.modules.applicant.services.auth;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.deenedev.rh_gestao_vagas.exceptions.NotFoundException;
import com.deenedev.rh_gestao_vagas.modules.applicant.models.entities.Applicant;
import com.deenedev.rh_gestao_vagas.modules.applicant.protocols.dto.ApplicantAuthDTO;
import com.deenedev.rh_gestao_vagas.modules.applicant.protocols.usecases.AuthApplicant;
import com.deenedev.rh_gestao_vagas.modules.applicant.repositories.ApplicantRepository;

import jakarta.security.auth.message.AuthException;

@Service
public class DbAuthApplicant implements AuthApplicant {
    @Value("${security.applicant.secret}")
    private String secret;

    @Autowired
    private ApplicantRepository applicantRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public String auth(ApplicantAuthDTO applicantAuthDTO) throws AuthException, RuntimeException {
        Applicant applicant = this.applicantRepository.findByEmail(applicantAuthDTO.getEmail()).orElseThrow(() -> new AuthException("Email/password is incorrect."));

        if (!passwordEncoder.matches(applicantAuthDTO.getPassword(), applicant.getPassword())) {
            throw new AuthException("Email/password is incorrect.");
        }

        return JWT.create().withIssuer("RH_GESTAO_VAGAS")
                .withSubject(applicant.getId().toString())
                .sign(Algorithm.HMAC256(this.secret));
    }
}
