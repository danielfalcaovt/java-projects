package com.deenedev.rh_gestao_vagas.modules.applicant.protocols.usecases;

import com.deenedev.rh_gestao_vagas.modules.applicant.models.entities.Applicant;

public interface CreateApplicant {
    Applicant create(Applicant applicantDTO);
}
