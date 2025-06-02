package com.example.prep.Domain.DTO.Response;

import lombok.Data;
import java.util.UUID;

@Data
public class ClienteResponseDTO {
    private UUID id;
    private String nombre;
    private String industria;
    private String emailContacto;
}