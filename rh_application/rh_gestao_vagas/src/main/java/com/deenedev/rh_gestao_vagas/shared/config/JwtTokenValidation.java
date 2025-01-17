package com.deenedev.rh_gestao_vagas.shared.config;

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

    public String verifyCompany(String token) {
        try{
            DecodedJWT result = JWT.require(Algorithm.HMAC256(this.companySecret)).build().verify(token);
            return result.getSubject();
        } catch(JWTVerificationException ex) {
            ex.getMessage();
            return null;
        }
    }

    public String verifyApplicant(String token) {
        try {
            DecodedJWT result = JWT.require(Algorithm.HMAC256(this.applicantSecret)).build().verify(token);
            return result.getSubject();
        } catch(JWTVerificationException ex) {
            return null;
        }
    }
}
