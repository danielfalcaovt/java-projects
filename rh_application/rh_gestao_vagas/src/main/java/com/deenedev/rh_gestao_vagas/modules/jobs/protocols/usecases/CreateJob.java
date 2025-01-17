package com.deenedev.rh_gestao_vagas.modules.jobs.protocols.usecases;

import com.deenedev.rh_gestao_vagas.modules.jobs.model.Job;

import jakarta.validation.ConstraintViolationException;

public interface CreateJob {
    Job create(Job job) throws ConstraintViolationException, IllegalArgumentException  ;
}
