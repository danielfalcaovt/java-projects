package com.deenedev.rh_gestao_vagas.modules.company.protocols.usecases;

import java.util.Optional;

import com.deenedev.rh_gestao_vagas.modules.company.models.entities.Company;

public interface GetCompanyByEmail {
    Optional<Company> getByEmail(String email);
}
