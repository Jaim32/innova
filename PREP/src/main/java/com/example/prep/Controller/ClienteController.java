package com.example.prep.Controller;

import com.example.prep.Domain.DTO.Create.CreateClienteDTO;
import com.example.prep.Domain.DTO.Response.ClienteResponseDTO;
import com.example.prep.Service.iClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/clientes")
public class ClienteController {

    @Autowired
    private iClienteService clienteService;

    @PostMapping
    public ResponseEntity<ClienteResponseDTO> crear(@RequestBody CreateClienteDTO dto) {
        return ResponseEntity.ok(clienteService.crearCliente(dto));
    }

    @GetMapping
    public ResponseEntity<List<ClienteResponseDTO>> listar() {
        return ResponseEntity.ok(clienteService.listarClientes());
    }

    @GetMapping("/{id}")
    public ResponseEntity<ClienteResponseDTO> obtener(@PathVariable UUID id) {
        return ResponseEntity.ok(clienteService.obtenerPorId(id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable UUID id) {
        clienteService.eliminarCliente(id);
        return ResponseEntity.noContent().build();
    }
}