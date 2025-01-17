package com.deenedev.rh_gestao_vagas.modules.jobs.controller;

import java.util.UUID;

import org.postgresql.util.PSQLException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.deenedev.rh_gestao_vagas.modules.jobs.controller.protocols.dto.CreateJobDTO;
import com.deenedev.rh_gestao_vagas.modules.jobs.model.Job;
import com.deenedev.rh_gestao_vagas.modules.jobs.protocols.usecases.CreateJob;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.validation.ConstraintViolationException;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/job")
public class JobController {
    @Autowired
    private CreateJob createJob;

    @PostMapping("/create")
    public ResponseEntity<Job> create(@Valid @RequestBody CreateJobDTO job, HttpServletRequest request)
            throws ConstraintViolationException, IllegalArgumentException {
        var companyId = request.getAttribute("company_id");
        Job createdJob = Job.builder()
                .level(job.getLevel())
                .role(job.getRole())
                .name(job.getName())
                .companyId(UUID.fromString(companyId.toString()))
                .description(job.getDescription())
                .build();
        return ResponseEntity.ok().body(this.createJob.create(createdJob));
    }
}
