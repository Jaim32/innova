package com.example.prep.Domain.DTO.Response;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;
@Data
@NoArgsConstructor
@AllArgsConstructor
class EvaluacionResponseDTO {
    private UUID id;
    private String fecha;
    private Integer puntaje;
    private String comentarios;
    private UUID empleadoId;
}