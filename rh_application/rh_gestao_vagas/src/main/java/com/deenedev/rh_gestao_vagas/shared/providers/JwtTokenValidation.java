package com.deenedev.rh_gestao_vagas.shared.providers;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTVerificationException;
import com.auth0.jwt.interfaces.DecodedJWT;

@Component
public class JwtTokenValidation {
    @Value("${security.applicant.secret}")
    private String applicantSecret;

    @Value("${security.company.secret}")
    private String companySecret;

    public DecodedJWT verifyCompany(String token) throws JWTVerificationException {
        return JWT.require(Algorithm.HMAC256(this.companySecret)).build().verify(token);
    }

    public DecodedJWT verifyApplicant(String token) throws JWTVerificationException {
        return JWT.require(Algorithm.HMAC256(this.applicantSecret)).build().verify(token);
    }
}
