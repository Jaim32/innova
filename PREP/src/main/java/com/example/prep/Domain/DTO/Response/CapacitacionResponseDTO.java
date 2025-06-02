package com.example.prep.Domain.DTO.Response;

import lombok.Data;
import java.time.LocalDate;
import java.util.UUID;

@Data
public class CapacitacionResponseDTO {
    private UUID id;
    private String tema;
    private LocalDate fecha;
    private int duracionHoras;
}
