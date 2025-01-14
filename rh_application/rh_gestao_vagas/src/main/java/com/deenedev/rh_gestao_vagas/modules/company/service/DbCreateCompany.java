package com.deenedev.rh_gestao_vagas.modules.company.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.deenedev.rh_gestao_vagas.modules.company.models.entities.Company;
import com.deenedev.rh_gestao_vagas.modules.company.protocols.usecases.CreateCompany;
import com.deenedev.rh_gestao_vagas.modules.company.repositories.CompanyRepository;

@Service
public class DbCreateCompany implements CreateCompany {
    @Autowired
    private CompanyRepository createCompanyRepository;

    @Override
    public Company create(Company company) {
        return this.createCompanyRepository.save(company);
    }
}
