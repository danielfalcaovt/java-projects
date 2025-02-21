package com.deenedev.rh_gestao_vagas.modules.company.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.deenedev.rh_gestao_vagas.exceptions.validation_exceptions.EmailAlreadyExistsException;
import com.deenedev.rh_gestao_vagas.modules.company.models.entities.Company;
import com.deenedev.rh_gestao_vagas.modules.company.protocols.usecases.CreateCompany;
import com.deenedev.rh_gestao_vagas.modules.company.repositories.CompanyRepository;

@Service
public class DbCreateCompany implements CreateCompany {
    @Autowired
    private CompanyRepository companyRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public Company create(Company company) throws EmailAlreadyExistsException {
        Optional<Company> companyFound = this.companyRepository.findOneByEmail(company.email);
        if (companyFound.isPresent()) {
            throw new EmailAlreadyExistsException();
        }

        company.setPassword(passwordEncoder.encode(company.password));
        return this.companyRepository.save(company);
    }
}
