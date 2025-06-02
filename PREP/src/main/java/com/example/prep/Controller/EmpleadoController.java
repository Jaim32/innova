package com.example.prep.Controller;

import com.example.prep.Domain.DTO.Create.CreateEmpleadoDTO;
import com.example.prep.Domain.DTO.Response.EmpleadoResponseDTO;
import com.example.prep.Service.iEmpleadoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/empleados")
public class EmpleadoController {

    @Autowired
    private iEmpleadoService empleadoService;

    @PostMapping
    public ResponseEntity<EmpleadoResponseDTO> crearEmpleado(@RequestBody CreateEmpleadoDTO dto) {
        return ResponseEntity.ok(empleadoService.crearEmpleado(dto));
    }

    @GetMapping
    public ResponseEntity<List<EmpleadoResponseDTO>> listarEmpleados() {
        return ResponseEntity.ok(empleadoService.listarEmpleados());
    }

    @GetMapping("/{id}")
    public ResponseEntity<EmpleadoResponseDTO> obtenerEmpleadoPorId(@PathVariable UUID id) {
        return ResponseEntity.ok(empleadoService.obtenerEmpleadoPorId(id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarEmpleado(@PathVariable UUID id) {
        empleadoService.eliminarEmpleado(id);
        return ResponseEntity.noContent().build();
    }

    @PostMapping("/{empleadoId}/proyectos/{proyectoId}")
    public ResponseEntity<Void> asignarProyecto(@PathVariable UUID empleadoId, @PathVariable UUID proyectoId) {
        empleadoService.asignarProyecto(empleadoId, proyectoId);
        return ResponseEntity.ok().build();
    }

    @PostMapping("/{empleadoId}/mentores/{mentorId}")
    public ResponseEntity<Void> asignarMentor(@PathVariable UUID empleadoId, @PathVariable UUID mentorId) {
        empleadoService.asignarMentor(empleadoId, mentorId);
        return ResponseEntity.ok().build();
    }

    @PostMapping("/{empleadoId}/capacitaciones/{capacitacionId}")
    public ResponseEntity<Void> asignarCapacitacion(@PathVariable UUID empleadoId, @PathVariable UUID capacitacionId) {
        empleadoService.asignarCapacitacion(empleadoId, capacitacionId);
        return ResponseEntity.ok().build();
    }
}