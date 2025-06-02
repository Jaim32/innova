package com.example.prep.Service.ServiceImplementation;
import com.example.prep.Domain.DTO.Create.CreateClienteDTO;
import com.example.prep.Domain.DTO.Response.ClienteResponseDTO;
import com.example.prep.Domain.Entity.Cliente;
import com.example.prep.Repository.iClienteRepository;
import com.example.prep.Service.iClienteService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class ClienteServiceImpl implements iClienteService {

    @Autowired
    private iClienteRepository clienteRepository;

    @Autowired
    private ModelMapper mapper;

    @Override
    public ClienteResponseDTO crearCliente(CreateClienteDTO dto) {
        Cliente cliente = new Cliente();
        cliente.setNombre(dto.getNombre());
        cliente.setIndustria(dto.getIndustria());
        cliente.setEmailContacto(dto.getEmailContacto());
        clienteRepository.save(cliente);
        return mapper.map(cliente, ClienteResponseDTO.class);
    }

    @Override
    public List<ClienteResponseDTO> listarClientes() {
        return clienteRepository.findAll().stream()
                .map(c -> mapper.map(c, ClienteResponseDTO.class))
                .collect(Collectors.toList());
    }

    @Override
    public ClienteResponseDTO obtenerPorId(UUID id) {
        return mapper.map(clienteRepository.findById(id).orElseThrow(), ClienteResponseDTO.class);
    }

    @Override
    public void eliminarCliente(UUID id) {
        clienteRepository.deleteById(id);
    }
}