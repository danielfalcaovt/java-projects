package com.deenedev.rh_gestao_vagas.modules.applicant.services.applicant;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.deenedev.rh_gestao_vagas.modules.applicant.models.entities.Applicant;
import com.deenedev.rh_gestao_vagas.modules.applicant.protocols.usecases.CreateApplicant;
import com.deenedev.rh_gestao_vagas.modules.applicant.repositories.ApplicantRepository;

@Service
public class DbCreateApplicant implements CreateApplicant {

    @Autowired
    private ApplicantRepository applicantRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public Applicant create(Applicant applicant) {
        applicant.setPassword(passwordEncoder.encode(applicant.getPassword()));
        return this.applicantRepository.save(applicant);
    }
}
