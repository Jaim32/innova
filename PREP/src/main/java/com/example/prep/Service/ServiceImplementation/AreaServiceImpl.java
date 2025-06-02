package com.example.prep.Service.ServiceImplementation;

import com.example.prep.Domain.Entity.Area;
import com.example.prep.Repository.iAreaRepository;
import com.example.prep.Service.iAreaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class AreaServiceImpl implements iAreaService {

    @Autowired
    private iAreaRepository areaRepository;

    @Override
    public Area crearArea(Area area) {
        return areaRepository.save(area);
    }

    @Override
    public List<Area> obtenerTodas() {
        return areaRepository.findAll();
    }

    @Override
    public Area obtenerPorId(UUID id) {
        return areaRepository.findById(id).orElseThrow();
    }

    @Override
    public void eliminarPorId(UUID id) {
        areaRepository.deleteById(id);
    }
}
