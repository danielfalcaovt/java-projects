package com.deenedev.rh_gestao_vagas.exceptions.handler;

import java.util.ArrayList;
import java.util.List;

import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.deenedev.rh_gestao_vagas.exceptions.protocols.ErrorMessageDTO;
import com.deenedev.rh_gestao_vagas.exceptions.validation_exceptions.EmailAlreadyExistsException;
import com.deenedev.rh_gestao_vagas.exceptions.validation_exceptions.NotFoundException;

import jakarta.security.auth.message.AuthException;

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

    @ExceptionHandler(exception = NotFoundException.class)
    public ResponseEntity<ErrorMessageDTO> handleFoundUserException(NotFoundException ex) {
        ErrorMessageDTO errorM = new ErrorMessageDTO(ex.getMessage(), "email");
        return new ResponseEntity<>(errorM, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(exception = AuthException.class)
    public ResponseEntity<ErrorMessageDTO> handleUnauthorizedException(AuthException ex) {
        ErrorMessageDTO errorM = new ErrorMessageDTO(ex.getMessage() == null ? "Email/password está incorreto." : ex.getMessage(), "email/password");
        return new ResponseEntity<>(errorM, HttpStatus.UNAUTHORIZED);
    }

    // All ExceptionHandler need to be at final of class

    @ExceptionHandler(exception = RuntimeException.class)
    public ResponseEntity<ErrorMessageDTO> handleInternalServerError(RuntimeException ex) {
        ErrorMessageDTO errorM = new ErrorMessageDTO("Internal Server Error", "internal");
        ex.printStackTrace();
        return new ResponseEntity<>(errorM, HttpStatus.INTERNAL_SERVER_ERROR);
    }

}
