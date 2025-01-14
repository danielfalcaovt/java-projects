package com.deenedev.rh_gestao_vagas.modules.applicant.services.applicant;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.deenedev.rh_gestao_vagas.modules.applicant.models.entities.Applicant;
import com.deenedev.rh_gestao_vagas.modules.applicant.protocols.usecases.CreateApplicant;
import com.deenedev.rh_gestao_vagas.modules.applicant.repositories.ApplicantRepository;

@Service
public class DbCreateApplicant implements CreateApplicant {

    @Autowired
    private ApplicantRepository applicantRepository;

    @Override
    public Applicant create(Applicant applicantDTO) {
        return this.applicantRepository.save(applicantDTO);
    }
  
}
