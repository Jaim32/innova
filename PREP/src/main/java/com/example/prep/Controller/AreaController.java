package com.example.prep.Controller;
import com.example.prep.Domain.Entity.Area;
import com.example.prep.Service.iAreaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;
@RestController
@RequestMapping("/api/area")
public class AreaController {

    @Autowired
    private iAreaService areaService;

    @PostMapping
    public ResponseEntity<Area> crear(@RequestBody Area area) {
        return ResponseEntity.ok(areaService.crearArea(area));
    }

    @GetMapping
    public ResponseEntity<List<Area>> listar() {
        return ResponseEntity.ok(areaService.obtenerTodas());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Area> obtenerPorId(@PathVariable UUID id) {
        return ResponseEntity.ok(areaService.obtenerPorId(id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable UUID id) {
        areaService.eliminarPorId(id);
        return ResponseEntity.noContent().build();
    }
}
