package com.example.prep.Domain.DTO.Response;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;
@Data
@NoArgsConstructor
@AllArgsConstructor
class TecnologiaResponseDTO {
    private UUID id;
    private String name;
    private String version;
}
