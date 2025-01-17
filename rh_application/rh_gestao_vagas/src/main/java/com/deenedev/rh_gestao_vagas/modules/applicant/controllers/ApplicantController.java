package com.deenedev.rh_gestao_vagas.modules.applicant.controllers;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.deenedev.rh_gestao_vagas.exceptions.validation_exceptions.EmailAlreadyExistsException;
import com.deenedev.rh_gestao_vagas.modules.applicant.models.entities.Applicant;
import com.deenedev.rh_gestao_vagas.modules.applicant.protocols.dto.ApplicantLoginDTO;
import com.deenedev.rh_gestao_vagas.modules.applicant.protocols.usecases.ApplicantAuthenticator;
import com.deenedev.rh_gestao_vagas.modules.applicant.protocols.usecases.CreateApplicant;
import com.deenedev.rh_gestao_vagas.modules.applicant.protocols.usecases.GetApplicantByEmail;

import jakarta.security.auth.message.AuthException;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/applicant")
public class ApplicantController {
    @Autowired
    private GetApplicantByEmail getApplicant;
    @Autowired
    private CreateApplicant createApplicant;
    @Autowired
    private ApplicantAuthenticator dbAuthApplicant;

    @PostMapping("/create")
    public ResponseEntity<Applicant> create(@Valid @RequestBody() Applicant applicantDTO) throws EmailAlreadyExistsException {
        Optional<Applicant> applicant = this.getApplicant.get(applicantDTO.getEmail());
        if (applicant.isPresent()) {
            throw new EmailAlreadyExistsException();
        }
        return ResponseEntity.status(201).body(this.createApplicant.create(applicantDTO));
    }

    @PostMapping("/login")
    public ResponseEntity<String> login(@Valid @RequestBody() ApplicantLoginDTO applicantDTO) throws AuthException {
        return ResponseEntity.ok().body(this.dbAuthApplicant.auth(applicantDTO));
    }
}