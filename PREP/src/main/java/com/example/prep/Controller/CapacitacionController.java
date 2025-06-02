package com.example.prep.Controller;

import com.example.prep.Domain.DTO.Create.CreateCapacitacionDTO;
import com.example.prep.Domain.DTO.Response.CapacitacionResponseDTO;
import com.example.prep.Service.iCapacitacionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/capacitaciones")
public class CapacitacionController {

    @Autowired
    private iCapacitacionService capacitacionService;

    @PostMapping
    public ResponseEntity<CapacitacionResponseDTO> crear(@RequestBody CreateCapacitacionDTO dto) {
        return ResponseEntity.ok(capacitacionService.crearCapacitacion(dto));
    }

    @GetMapping
    public ResponseEntity<List<CapacitacionResponseDTO>> listar() {
        return ResponseEntity.ok(capacitacionService.listarCapacitaciones());
    }

    @GetMapping("/{id}")
    public ResponseEntity<CapacitacionResponseDTO> obtener(@PathVariable UUID id) {
        return ResponseEntity.ok(capacitacionService.obtenerPorId(id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable UUID id) {
        capacitacionService.eliminarCapacitacion(id);
        return ResponseEntity.noContent().build();
    }
}
