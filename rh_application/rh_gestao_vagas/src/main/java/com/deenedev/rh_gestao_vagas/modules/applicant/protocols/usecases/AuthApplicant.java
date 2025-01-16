package com.deenedev.rh_gestao_vagas.modules.applicant.protocols.usecases;

import com.deenedev.rh_gestao_vagas.modules.applicant.protocols.dto.ApplicantAuthDTO;

import jakarta.security.auth.message.AuthException;

public interface AuthApplicant {
    String auth(ApplicantAuthDTO applicantAuthDTO) throws AuthException, RuntimeException; 
}
