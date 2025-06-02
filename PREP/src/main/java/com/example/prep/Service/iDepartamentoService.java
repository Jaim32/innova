package com.example.prep.Service;

import com.example.prep.Domain.DTO.Create.CreateDepartamentoDTO;
import com.example.prep.Domain.DTO.Response.DepartamentoResponseDTO;
import java.util.List;
import java.util.UUID;

public interface iDepartamentoService {
    DepartamentoResponseDTO crearDepartamento(CreateDepartamentoDTO dto);
    List<DepartamentoResponseDTO> listarDepartamentos();
    DepartamentoResponseDTO obtenerPorId(UUID id);
    void eliminarDepartamento(UUID id);
}
