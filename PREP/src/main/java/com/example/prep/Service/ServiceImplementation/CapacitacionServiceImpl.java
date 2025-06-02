package com.example.prep.Service.ServiceImplementation;

import com.example.prep.Domain.DTO.Create.CreateCapacitacionDTO;
import com.example.prep.Domain.DTO.Response.CapacitacionResponseDTO;
import com.example.prep.Domain.Entity.Capacitacion;
import com.example.prep.Repository.iCapacitacionRepository;
import com.example.prep.Service.iCapacitacionService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class CapacitacionServiceImpl implements iCapacitacionService {

    @Autowired
    private iCapacitacionRepository capacitacionRepository;

    @Autowired
    private ModelMapper mapper;

    @Override
    public CapacitacionResponseDTO crearCapacitacion(CreateCapacitacionDTO dto) {
        Capacitacion c = new Capacitacion();
        c.setTema(dto.getTema());
        c.setFecha(dto.getFecha());
        c.setDuracionHoras(dto.getDuracionHoras());
        capacitacionRepository.save(c);
        return mapper.map(c, CapacitacionResponseDTO.class);
    }

    @Override
    public List<CapacitacionResponseDTO> listarCapacitaciones() {
        return capacitacionRepository.findAll().stream()
                .map(c -> mapper.map(c, CapacitacionResponseDTO.class))
                .collect(Collectors.toList());
    }

    @Override
    public CapacitacionResponseDTO obtenerPorId(UUID id) {
        return mapper.map(capacitacionRepository.findById(id).orElseThrow(), CapacitacionResponseDTO.class);
    }

    @Override
    public void eliminarCapacitacion(UUID id) {
        capacitacionRepository.deleteById(id);
    }
}
