package com.deenedev.rh_gestao_vagas.shared.config;

import java.io.IOException;
import java.util.Collections;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@Component
public class SecurityFilter extends OncePerRequestFilter {
    @Autowired
    private JwtTokenValidation jwtTokenValidation;

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
            throws ServletException, IOException {
        SecurityContextHolder.getContext().setAuthentication(null);
        if (!this.isAuthenticatedRoute(request.getRequestURI())) {
            filterChain.doFilter(request, response);
            return;
        }
        String token = request.getHeader("Authorization").replace("Bearer ", "");
        String subjectToken = "";
        String userId = "";
        if (request.getRequestURI().contains("job") || request.getRequestURI().contains("company")) {
            System.out.println("VALIDANDO COMPANY");
            subjectToken = this.jwtTokenValidation.verifyCompany(token);
            userId = "company_id";
        }
        if (request.getRequestURI().contains("applicant")) {
            System.out.println("VALIDANDO APPLICANT");
            subjectToken = this.jwtTokenValidation.verifyApplicant(token);
            userId = "applicant_id";
        }

        if (subjectToken.isEmpty() || userId.isEmpty()) {
            response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
            return;
        }
        
        request.setAttribute(userId, subjectToken);
        filterChain.doFilter(request, response);

        UsernamePasswordAuthenticationToken auth = new UsernamePasswordAuthenticationToken(token,
                Collections.emptyList());
        SecurityContextHolder.getContext().setAuthentication(auth);
        return;
    }

    private boolean isAuthenticatedRoute(String route) {
        String[] routes = { "/company/create", "/applicant/create", "/company/login", "/applicant/login" };
        for (String noAuthRoute : routes) {
            if (noAuthRoute.equals(route)) {
                return false;
            }
        }
        return true;
    }
}
