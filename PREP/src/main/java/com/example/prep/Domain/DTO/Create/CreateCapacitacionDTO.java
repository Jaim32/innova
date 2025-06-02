package com.example.prep.Domain.DTO.Create;

import lombok.Data;
import java.time.LocalDate;

@Data
public class CreateCapacitacionDTO {
    private String tema;
    private LocalDate fecha;
    private int duracionHoras;
}