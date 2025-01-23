package com.deenedev.rh_gestao_vagas.modules.applicant.protocols.usecases;

import com.deenedev.rh_gestao_vagas.modules.applicant.controllers.protocols.dto.ApplicantLoginDTO;
import com.deenedev.rh_gestao_vagas.shared.protocols.dto.AuthenticatorResponse;
import com.deenedev.rh_gestao_vagas.shared.protocols.usecases.Authenticator;

public interface ApplicantAuthenticator extends Authenticator<ApplicantLoginDTO, AuthenticatorResponse> {}
