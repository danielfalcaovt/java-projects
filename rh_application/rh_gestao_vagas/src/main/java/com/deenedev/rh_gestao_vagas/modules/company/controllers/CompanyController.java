package com.deenedev.rh_gestao_vagas.modules.company.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.deenedev.rh_gestao_vagas.exceptions.validation_exceptions.EmailAlreadyExistsException;
import com.deenedev.rh_gestao_vagas.modules.company.controllers.protocols.dto.CompanyLoginDTO;
import com.deenedev.rh_gestao_vagas.modules.company.controllers.protocols.dto.CompanySignUpDTO;
import com.deenedev.rh_gestao_vagas.modules.company.models.entities.Company;
import com.deenedev.rh_gestao_vagas.modules.company.protocols.usecases.CompanyAuthenticator;
import com.deenedev.rh_gestao_vagas.modules.company.protocols.usecases.CreateCompany;
import com.deenedev.rh_gestao_vagas.shared.protocols.dto.AuthenticatorResponse;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/company")
public class CompanyController {

    @Autowired
    private CreateCompany createCompany;

    @Autowired
    private CompanyAuthenticator authenticator;

    @PostMapping("/signup")
    public ResponseEntity<Company> create(@Valid @RequestBody() CompanySignUpDTO companyDTO)
            throws EmailAlreadyExistsException {
        Company company = Company.build(
            companyDTO.getName(),
            companyDTO.getCnpj(),
            companyDTO.getEmail(),
            companyDTO.getPassword()
        );
        return ResponseEntity.ok().body(this.createCompany.create(company));
    }

    @PostMapping("/login")
    public ResponseEntity<AuthenticatorResponse> login(@Valid @RequestBody() CompanyLoginDTO loginDTO) throws Exception {
        return ResponseEntity.ok().body(this.authenticator.auth(loginDTO));
    }
}
