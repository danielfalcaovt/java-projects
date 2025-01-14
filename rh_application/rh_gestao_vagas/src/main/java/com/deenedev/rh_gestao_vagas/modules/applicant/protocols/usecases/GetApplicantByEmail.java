package com.deenedev.rh_gestao_vagas.modules.applicant.protocols.usecases;

import java.util.Optional;

import com.deenedev.rh_gestao_vagas.modules.applicant.models.entities.Applicant;

public interface GetApplicantByEmail {
    Optional<Applicant> get(String email);
}
