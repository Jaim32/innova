package com.example.prep.Service;

import com.example.prep.Domain.DTO.Create.CreateEmpleadoDTO;
import com.example.prep.Domain.DTO.Response.EmpleadoResponseDTO;
import java.util.List;
import java.util.UUID;

public interface iEmpleadoService {
    EmpleadoResponseDTO crearEmpleado(CreateEmpleadoDTO dto);
    EmpleadoResponseDTO obtenerEmpleadoPorId(UUID id);
    List<EmpleadoResponseDTO> listarEmpleados();
    void eliminarEmpleado(UUID id);
    void asignarProyecto(UUID empleadoId, UUID proyectoId);
    void asignarMentor(UUID empleadoId, UUID mentorId);
    void asignarCapacitacion(UUID empleadoId, UUID capacitacionId);
}