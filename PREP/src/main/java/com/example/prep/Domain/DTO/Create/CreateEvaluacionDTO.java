package com.example.prep.Domain.DTO.Create;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
class CreateEvaluacionDTO {
    private String fecha; // ISO LocalDate format
    private Integer puntaje;
    private String comentarios;
    private UUID empleadoId;
}