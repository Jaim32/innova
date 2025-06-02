package com.example.prep.Controller;

import com.example.prep.Domain.DTO.Create.CreateDepartamentoDTO;
import com.example.prep.Domain.DTO.Response.DepartamentoResponseDTO;
import com.example.prep.Service.iDepartamentoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/departamentos")
public class DepartamentoController {

    @Autowired
    private iDepartamentoService departamentoService;

    @PostMapping
    public ResponseEntity<DepartamentoResponseDTO> crear(@RequestBody CreateDepartamentoDTO dto) {
        return ResponseEntity.ok(departamentoService.crearDepartamento(dto));
    }

    @GetMapping
    public ResponseEntity<List<DepartamentoResponseDTO>> listar() {
        return ResponseEntity.ok(departamentoService.listarDepartamentos());
    }

    @GetMapping("/{id}")
    public ResponseEntity<DepartamentoResponseDTO> obtener(@PathVariable UUID id) {
        return ResponseEntity.ok(departamentoService.obtenerPorId(id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable UUID id) {
        departamentoService.eliminarDepartamento(id);
        return ResponseEntity.noContent().build();
    }
}
