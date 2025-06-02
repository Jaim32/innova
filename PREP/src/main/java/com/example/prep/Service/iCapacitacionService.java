package com.example.prep.Service;


import com.example.prep.Domain.DTO.Create.CreateCapacitacionDTO;
import com.example.prep.Domain.DTO.Response.CapacitacionResponseDTO;
import java.util.List;
import java.util.UUID;

public interface iCapacitacionService {
    CapacitacionResponseDTO crearCapacitacion(CreateCapacitacionDTO dto);
    List<CapacitacionResponseDTO> listarCapacitaciones();
    CapacitacionResponseDTO obtenerPorId(UUID id);
    void eliminarCapacitacion(UUID id);
}