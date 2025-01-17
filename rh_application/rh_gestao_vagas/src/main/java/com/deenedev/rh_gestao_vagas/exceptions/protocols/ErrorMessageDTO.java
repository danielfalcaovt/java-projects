package com.deenedev.rh_gestao_vagas.exceptions.protocols;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ErrorMessageDTO {
    public String messsage;
    public String fieldName;
}