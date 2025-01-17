package com.deenedev.rh_gestao_vagas.modules.applicant.protocols.usecases;

import com.deenedev.rh_gestao_vagas.modules.applicant.protocols.dto.ApplicantLoginDTO;
import com.deenedev.rh_gestao_vagas.shared.protocols.usecases.Authenticator;

public interface ApplicantAuthenticator extends Authenticator<ApplicantLoginDTO> {}
