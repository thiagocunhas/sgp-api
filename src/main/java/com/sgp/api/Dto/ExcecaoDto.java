package com.sgp.api.Dto;

import java.time.LocalDate;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor

public class ExcecaoDto {
 
    
@JsonFormat(pattern = "dd/MM/yyyy")    
private LocalDate data;
private List<String> erros;

}
