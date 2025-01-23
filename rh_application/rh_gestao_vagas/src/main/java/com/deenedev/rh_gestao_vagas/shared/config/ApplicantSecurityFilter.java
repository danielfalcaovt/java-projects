package com.deenedev.rh_gestao_vagas.shared.config;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import com.auth0.jwt.interfaces.DecodedJWT;
import com.deenedev.rh_gestao_vagas.shared.providers.JwtTokenValidation;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@Component
public class ApplicantSecurityFilter extends OncePerRequestFilter {
    @Autowired
    private JwtTokenValidation jwtTokenValidation;

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
            throws ServletException, IOException {
        if (request.getRequestURI().contains("applicant") && (!request.getRequestURI().contains("/login") && !request.getRequestURI().contains("/signup"))) {
            SecurityContextHolder.getContext().setAuthentication(null);
            String token = request.getHeader("Authorization").replace("Bearer ", "");
            if (token.isEmpty() || token == null) {
                response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
                return;
            }

            DecodedJWT result = this.jwtTokenValidation.verifyApplicant(token);
            request.setAttribute("applicant_id", result.getSubject());

            var roles = result.getClaim("roles").asList(Object.class);
            var grants = roles.stream().map(role -> new SimpleGrantedAuthority("ROLE_" + role.toString().toUpperCase())).toList();

            UsernamePasswordAuthenticationToken auth = new UsernamePasswordAuthenticationToken(token, null,
                    grants);
            SecurityContextHolder.getContext().setAuthentication(auth);
        }
        filterChain.doFilter(request, response);

        return;
    }
}
