package com.deenedev.rh_gestao_vagas.modules.company.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.deenedev.rh_gestao_vagas.modules.company.models.entities.Company;
import com.deenedev.rh_gestao_vagas.modules.company.protocols.usecases.GetCompanyByEmail;
import com.deenedev.rh_gestao_vagas.modules.company.repositories.CompanyRepository;

@Service
public class DbGetCompanyByEmail implements GetCompanyByEmail {
    
    @Autowired
    private CompanyRepository getCompanyByEmailRepository;

    @Override
    public Optional<Company> getByEmail(String email) {
        return this.getCompanyByEmailRepository.findOneByEmail(email);
    }
}
