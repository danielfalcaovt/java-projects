package com.deenedev.rh_gestao_vagas.modules.applicant.services.applicant;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.deenedev.rh_gestao_vagas.modules.applicant.models.entities.Applicant;
import com.deenedev.rh_gestao_vagas.modules.applicant.protocols.usecases.GetApplicantByEmail;
import com.deenedev.rh_gestao_vagas.modules.applicant.repositories.ApplicantRepository;

@Service
public class DbGetApplicantByEmail implements GetApplicantByEmail {
    @Autowired
    private ApplicantRepository applicantRepository;

    @Override
    public Optional<Applicant> get(String email) {
        Optional<Applicant> applicant = this.applicantRepository.findOneByEmail(email);
        return applicant;
    }
}
