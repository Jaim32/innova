package com.example.prep.Domain.DTO.Create;

import lombok.Data;
import java.time.LocalDate;
import java.util.UUID;

@Data
public class CreateEmpleadoDTO {
    private String nombre;
    private String apellido;
    private String email;
    private LocalDate fechaIngreso;
    private String puesto;
    private UUID departamentoId;
}