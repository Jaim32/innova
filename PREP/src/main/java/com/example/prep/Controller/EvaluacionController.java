package com.example.prep.Controller;
import com.example.prep.Domain.Entity.Evaluacion;
import com.example.prep.Service.iEvaluacionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;
@RestController
@RequestMapping("/api/evaluacion")
public class EvaluacionController {

    @Autowired
    private iEvaluacionService evaluacionService;

    @PostMapping
    public ResponseEntity<Evaluacion> crear(@RequestBody Evaluacion evaluacion) {
        return ResponseEntity.ok(evaluacionService.crearEvaluacion(evaluacion));
    }

    @GetMapping("/empleado/{idEmpleado}")
    public ResponseEntity<List<Evaluacion>> listarPorEmpleado(@PathVariable UUID idEmpleado) {
        return ResponseEntity.ok(evaluacionService.listarPorEmpleado(idEmpleado));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable UUID id) {
        evaluacionService.eliminarPorId(id);
        return ResponseEntity.noContent().build();
    }
}

