package com.sgp.api.exception;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.sgp.api.Dto.ExcecaoDto;

@RestControllerAdvice
public class GlobalExceptionHandler {
    
  @ExceptionHandler(MethodArgumentNotValidException.class)
  public ResponseEntity<ExcecaoDto> tratarExcecaoValidacao(MethodArgumentNotValidException ex) {
     List<FieldError> camposErros = ex.getFieldErrors();

     List<String> erros = new ArrayList<>();

     for (FieldError campoErro : camposErros) {
        String erro = campoErro.getDefaultMessage();

        erros.add(erro);

     }


     ExcecaoDto dto = new ExcecaoDto(LocalDate.now(), erros);


    return ResponseEntity.badRequest().body(dto);

  }

  @ExceptionHandler(Exception.class)
  public ResponseEntity<ExcecaoDto> tratarExcecoesGenericas(Exception ex) {
     List<String> erros = new ArrayList<>();

     erros.add( "ERro Inesperado! Tente novamente mais tarde.");
     erros.add(ex.toString());

    return ResponseEntity.internalServerError().body(new ExcecaoDto(LocalDate.now(), erros));

  }


}
