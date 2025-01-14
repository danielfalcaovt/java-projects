package com.deenedev.rh_gestao_vagas.modules.applicant.repositories;

import java.util.Optional;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.deenedev.rh_gestao_vagas.modules.applicant.models.entities.Applicant;

public interface ApplicantRepository extends JpaRepository<Applicant, UUID> {
    @Query("SELECT 1 FROM Applicant a WHERE a.email = :email")
    Optional<Applicant> findOneByEmail(String email);
}
