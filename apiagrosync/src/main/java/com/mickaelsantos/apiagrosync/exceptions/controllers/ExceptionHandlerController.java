package com.mickaelsantos.apiagrosync.exceptions.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.mickaelsantos.apiagrosync.exceptions.dtos.ErrorMessageDto;

@ControllerAdvice
public class ExceptionHandlerController 
{
    private MessageSource messageSource;

    public ExceptionHandlerController(MessageSource message)
    {
        this.messageSource = message;
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<List<ErrorMessageDto>> HandleMethodArgumentNotValidException(MethodArgumentNotValidException ex)
    {
        List<ErrorMessageDto> DTOs = new ArrayList<>();

        ex.getBindingResult().getFieldErrors().forEach(x -> {
            String message = messageSource.getMessage(x, LocaleContextHolder.getLocale());
            ErrorMessageDto error = new ErrorMessageDto(message, x.getField());
            DTOs.add(error);
        });

        return new ResponseEntity<>(DTOs, HttpStatus.BAD_REQUEST);
    }
}   
    