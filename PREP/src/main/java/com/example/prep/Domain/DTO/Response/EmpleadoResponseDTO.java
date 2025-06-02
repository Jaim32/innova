package com.example.prep.Domain.DTO.Response;

import lombok.Data;
import java.time.LocalDate;
import java.util.UUID;

@Data
public class EmpleadoResponseDTO {
    private UUID id;
    private String nombre;
    private String apellido;
    private String email;
    private LocalDate fechaIngreso;
    private String puesto;
    private String nombreDepartamento;
}
