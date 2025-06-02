package com.example.prep.Domain.DTO.Create;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CreateTecnologiaDTO {
    private String name;
    private String version;
}
