package com.example.prep.Controller;

import com.example.prep.Domain.Entity.Tecnologia;
import com.example.prep.Service.iTecnologiaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/tecnologia")
public class TecnologiaController {

    @Autowired
    private iTecnologiaService tecnologiaService;

    @PostMapping
    public ResponseEntity<Tecnologia> crear(@RequestBody Tecnologia tecnologia) {
        return ResponseEntity.ok(tecnologiaService.crearTecnologia(tecnologia));
    }

    @GetMapping
    public ResponseEntity<List<Tecnologia>> listar() {
        return ResponseEntity.ok(tecnologiaService.obtenerTodas());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Tecnologia> obtenerPorId(@PathVariable UUID id) {
        return ResponseEntity.ok(tecnologiaService.obtenerPorId(id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable UUID id) {
        tecnologiaService.eliminarPorId(id);
        return ResponseEntity.noContent().build();
    }
}
