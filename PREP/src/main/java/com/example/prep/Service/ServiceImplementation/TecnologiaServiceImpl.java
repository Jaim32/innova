package com.example.prep.Service.ServiceImplementation;

import com.example.prep.Domain.Entity.Tecnologia;
import com.example.prep.Repository.iTecnologiaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class TecnologiaServiceImpl implements iTecnologiaService {

    @Autowired
    private iTecnologiaRepository tecnologiaRepository;

    @Override
    public Tecnologia crearTecnologia(Tecnologia tecnologia) {
        return tecnologiaRepository.save(tecnologia);
    }

    @Override
    public List<Tecnologia> obtenerTodas() {
        return tecnologiaRepository.findAll();
    }

    @Override
    public Tecnologia obtenerPorId(UUID id) {
        return tecnologiaRepository.findById(id).orElseThrow();
    }

    @Override
    public void eliminarPorId(UUID id) {
        tecnologiaRepository.deleteById(id);
    }
}