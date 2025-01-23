package com.deenedev.rh_gestao_vagas.modules.company.protocols.usecases;

import com.deenedev.rh_gestao_vagas.modules.company.controllers.protocols.dto.CompanyLoginDTO;
import com.deenedev.rh_gestao_vagas.shared.protocols.dto.AuthenticatorResponse;
import com.deenedev.rh_gestao_vagas.shared.protocols.usecases.Authenticator;

public interface CompanyAuthenticator extends Authenticator<CompanyLoginDTO, AuthenticatorResponse> {}
