package com.example.prep.Service.ServiceImplementation;

import com.example.prep.Domain.DTO.Create.CreateDepartamentoDTO;
import com.example.prep.Domain.DTO.Response.DepartamentoResponseDTO;
import com.example.prep.Domain.Entity.Departamento;
import com.example.prep.Repository.iDepartamentoRepository;
import com.example.prep.Service.iDepartamentoService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class DepartamentoServiceImpl implements iDepartamentoService {

    @Autowired
    private iDepartamentoRepository departamentoRepository;

    @Autowired
    private ModelMapper mapper;

    @Override
    public DepartamentoResponseDTO crearDepartamento(CreateDepartamentoDTO dto) {
        Departamento departamento = new Departamento();
        departamento.setNombre(dto.getNombre());
        departamentoRepository.save(departamento);
        return mapper.map(departamento, DepartamentoResponseDTO.class);
    }

    @Override
    public List<DepartamentoResponseDTO> listarDepartamentos() {
        return departamentoRepository.findAll().stream()
                .map(d -> mapper.map(d, DepartamentoResponseDTO.class))
                .collect(Collectors.toList());
    }

    @Override
    public DepartamentoResponseDTO obtenerPorId(UUID id) {
        Departamento d = departamentoRepository.findById(id).orElseThrow();
        return mapper.map(d, DepartamentoResponseDTO.class);
    }

    @Override
    public void eliminarDepartamento(UUID id) {
        departamentoRepository.deleteById(id);
}
}