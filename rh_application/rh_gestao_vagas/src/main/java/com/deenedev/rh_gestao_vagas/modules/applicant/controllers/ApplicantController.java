package com.deenedev.rh_gestao_vagas.modules.applicant.controllers;

import java.security.InvalidParameterException;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.deenedev.rh_gestao_vagas.exceptions.validation_exceptions.EmailAlreadyExistsException;
import com.deenedev.rh_gestao_vagas.modules.applicant.controllers.protocols.dto.ApplicantLoginDTO;
import com.deenedev.rh_gestao_vagas.modules.applicant.controllers.protocols.dto.CreateApplicantDTO;
import com.deenedev.rh_gestao_vagas.modules.applicant.controllers.protocols.dto.ResponseCreateApplicantDTO;
import com.deenedev.rh_gestao_vagas.modules.applicant.models.entities.Applicant;
import com.deenedev.rh_gestao_vagas.modules.applicant.protocols.usecases.ApplicantAuthenticator;
import com.deenedev.rh_gestao_vagas.modules.applicant.protocols.usecases.CreateApplicant;
import com.deenedev.rh_gestao_vagas.modules.applicant.protocols.usecases.GetApplicantByEmail;
import com.deenedev.rh_gestao_vagas.shared.protocols.dto.AuthenticatorResponse;

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

    @PostMapping("/signup")
    public ResponseEntity<ResponseCreateApplicantDTO> create(@Valid @RequestBody() CreateApplicantDTO applicantDTO)
            throws EmailAlreadyExistsException {
        Optional<Applicant> foundApplicant = this.getApplicant.get(applicantDTO.email());
        if (!applicantDTO.password().equals(applicantDTO.confirmPassword())) {
            throw new InvalidParameterException("confirmPassword");
        }
        if (foundApplicant.isPresent()) {
            throw new EmailAlreadyExistsException();
        }

        Applicant createdApplicant = Applicant.build(
            applicantDTO.name(),
            applicantDTO.cpf(),
            applicantDTO.email(),
            applicantDTO.password(),
            applicantDTO.curriculum(),
            applicantDTO.description()
        );

        Applicant applicant = this.createApplicant.create(createdApplicant);
        
        ResponseCreateApplicantDTO response = new ResponseCreateApplicantDTO(
                    applicant.getName(),
                    applicant.getCpf(), 
                    applicant.getEmail(), 
                    applicant.getCurriculum(),
                    applicant.getDescription()
                );

        return ResponseEntity.status(201).body(response);
    }

    @PostMapping("/login")
    public ResponseEntity<AuthenticatorResponse> login(@Valid @RequestBody() ApplicantLoginDTO applicantDTO)
            throws AuthException {
        return ResponseEntity.ok().body(this.dbAuthApplicant.auth(applicantDTO));
    }
}