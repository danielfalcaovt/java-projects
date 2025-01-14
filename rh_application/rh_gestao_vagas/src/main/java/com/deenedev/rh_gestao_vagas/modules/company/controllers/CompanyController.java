package com.deenedev.rh_gestao_vagas.modules.company.controllers;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.deenedev.rh_gestao_vagas.exceptions.EmailAlreadyExistsException;
import com.deenedev.rh_gestao_vagas.modules.company.models.entities.Company;
import com.deenedev.rh_gestao_vagas.modules.company.protocols.usecases.CreateCompany;
import com.deenedev.rh_gestao_vagas.modules.company.protocols.usecases.GetCompanyByEmail;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/company")
public class CompanyController {

    @Autowired
    private CreateCompany createCompany;

    @Autowired
    private GetCompanyByEmail getCompanyByEmail;

    @PostMapping("/create")
    public ResponseEntity<Company> create(@Valid @RequestBody() Company company) throws EmailAlreadyExistsException {
        Optional<Company> companyFound = this.getCompanyByEmail.getByEmail(company.email);
        if (companyFound.isPresent()) {
            throw new EmailAlreadyExistsException();
        }
        return ResponseEntity.ok().body(this.createCompany.create(company));
    }
}
