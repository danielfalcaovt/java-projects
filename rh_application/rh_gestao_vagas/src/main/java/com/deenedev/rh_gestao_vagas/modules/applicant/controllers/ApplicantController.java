package com.deenedev.rh_gestao_vagas.modules.applicant.controllers;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.deenedev.rh_gestao_vagas.exceptions.EmailAlreadyExistsException;
import com.deenedev.rh_gestao_vagas.modules.applicant.models.entities.Applicant;
import com.deenedev.rh_gestao_vagas.modules.applicant.protocols.usecases.CreateApplicant;
import com.deenedev.rh_gestao_vagas.modules.applicant.protocols.usecases.GetApplicantByEmail;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/applicant")
public class ApplicantController {
    @Autowired
    private GetApplicantByEmail getApplicant;
    @Autowired(required = true)
    private CreateApplicant createApplicant;

    @PostMapping()
    public ResponseEntity<Applicant> create(@Valid @RequestBody() Applicant applicantDTO) throws EmailAlreadyExistsException {
        Optional<Applicant> applicant = this.getApplicant.get(applicantDTO.getEmail());
        if (applicant.isPresent()) {
            throw new EmailAlreadyExistsException();
        }
        return ResponseEntity.ok().body(this.createApplicant.create(applicantDTO));
    }
}