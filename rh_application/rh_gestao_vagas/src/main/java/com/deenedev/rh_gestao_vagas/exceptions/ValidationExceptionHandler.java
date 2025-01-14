package com.deenedev.rh_gestao_vagas.exceptions;

import java.util.ArrayList;
import java.util.List;

import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ValidationExceptionHandler {

    private MessageSource messageSource;
    public ValidationExceptionHandler(MessageSource m) {
        this.messageSource = m;
    }

    @ExceptionHandler(exception = MethodArgumentNotValidException.class)
    public ResponseEntity<List<ErrorMessageDTO>> handleException(MethodArgumentNotValidException ex) throws Exception  {
        List<ErrorMessageDTO> errorMessages = new ArrayList<ErrorMessageDTO>();
        ex.getBindingResult().getFieldErrors().forEach(err -> {
            ErrorMessageDTO errorM = new ErrorMessageDTO(this.messageSource.getMessage(err, LocaleContextHolder.getLocale()), err.getField());
            errorMessages.add(errorM);
        });
        return new ResponseEntity<>(errorMessages, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(exception = EmailAlreadyExistsException.class)
    public ResponseEntity<ErrorMessageDTO> handleFoundUserException(EmailAlreadyExistsException ex) {
        ErrorMessageDTO errorM = new ErrorMessageDTO(ex.getMessage(), "email");
        return new ResponseEntity<>(errorM, HttpStatus.BAD_REQUEST);
    }
}
