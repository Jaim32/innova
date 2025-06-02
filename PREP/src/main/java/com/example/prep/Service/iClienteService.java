package com.example.prep.Service;

import com.example.prep.Domain.DTO.Create.CreateClienteDTO;
import com.example.prep.Domain.DTO.Response.ClienteResponseDTO;
import java.util.List;
import java.util.UUID;

public interface iClienteService {
    ClienteResponseDTO crearCliente(CreateClienteDTO dto);
    List<ClienteResponseDTO> listarClientes();
    ClienteResponseDTO obtenerPorId(UUID id);
    void eliminarCliente(UUID id);
}