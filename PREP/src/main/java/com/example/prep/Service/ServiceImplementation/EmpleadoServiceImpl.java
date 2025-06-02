package com.example.prep.Service.ServiceImplementation;

import com.example.prep.Domain.DTO.Create.CreateEmpleadoDTO;
import com.example.prep.Domain.DTO.Response.EmpleadoResponseDTO;
import com.example.prep.Domain.Entity.*;
import com.example.prep.Repository.*;
import com.example.prep.Service.iEmpleadoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.modelmapper.ModelMapper;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class EmpleadoServiceImpl implements iEmpleadoService {

    @Autowired private iEmpleadoRepository empleadoRepository;
    @Autowired private iProyectoRepository proyectoRepository;
    @Autowired private iCapacitacionRepository capacitacionRepository;
    @Autowired private iDepartamentoRepository departamentoRepository;
    @Autowired private ModelMapper mapper;

    @Override
    public EmpleadoResponseDTO crearEmpleado(CreateEmpleadoDTO dto) {
        Empleado empleado = new Empleado();
        empleado.setNombre(dto.getNombre());
        empleado.setApellido(dto.getApellido());
        empleado.setEmail(dto.getEmail());
        empleado.setFechaIngreso(dto.getFechaIngreso());
        empleado.setPuesto(dto.getPuesto());

        Departamento depto = departamentoRepository.findById(dto.getDepartamentoId())
                .orElseThrow();
        empleado.setDepartamento(depto);

        empleadoRepository.save(empleado);
        return mapper.map(empleado, EmpleadoResponseDTO.class);
    }

    @Override
    public EmpleadoResponseDTO obtenerEmpleadoPorId(UUID id) {
        Empleado empleado = empleadoRepository.findById(id).orElseThrow();
        return mapper.map(empleado, EmpleadoResponseDTO.class);
    }

    @Override
    public List<EmpleadoResponseDTO> listarEmpleados() {
        return empleadoRepository.findAll().stream()
                .map(e -> mapper.map(e, EmpleadoResponseDTO.class))
                .collect(Collectors.toList());
    }

    @Override
    public void eliminarEmpleado(UUID id) {
        empleadoRepository.deleteById(id);
    }

    @Override
    public void asignarProyecto(UUID empleadoId, UUID proyectoId) {
        Empleado empleado = empleadoRepository.findById(empleadoId).orElseThrow();
        Proyecto proyecto = proyectoRepository.findById(proyectoId).orElseThrow();
        empleado.getProyectos().add(proyecto);
        empleadoRepository.save(empleado);
    }

    @Override
    public void asignarMentor(UUID empleadoId, UUID mentorId) {
        Empleado empleado = empleadoRepository.findById(empleadoId).orElseThrow();
        Empleado mentor = empleadoRepository.findById(mentorId).orElseThrow();
        empleado.getMentores().add(mentor);
        empleadoRepository.save(empleado);
    }

    @Override
    public void asignarCapacitacion(UUID empleadoId, UUID capacitacionId) {
        Empleado empleado = empleadoRepository.findById(empleadoId).orElseThrow();
        Capacitacion capacitacion = capacitacionRepository.findById(capacitacionId).orElseThrow();
        empleado.getCapacitaciones().add(capacitacion);
        empleadoRepository.save(empleado);
    }
}
