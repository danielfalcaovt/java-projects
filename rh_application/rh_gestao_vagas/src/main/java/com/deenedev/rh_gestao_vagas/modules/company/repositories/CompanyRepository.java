package com.deenedev.rh_gestao_vagas.modules.company.repositories;

import java.util.Optional;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.deenedev.rh_gestao_vagas.modules.company.models.entities.Company;

public interface CompanyRepository extends JpaRepository<Company, UUID> {
    @Query(value = "SELECT 1 from Company a WHERE a.email = :email")
    Optional<Company> findOneByEmail(String email);

    Optional<Company> findByEmail(String email);
}
