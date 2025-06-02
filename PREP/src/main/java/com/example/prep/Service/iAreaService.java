package com.example.prep.Service;

import com.example.prep.Domain.Entity.Area;

import java.util.List;
import java.util.UUID;

public interface iAreaService {
    Area crearArea(Area area);
    List<Area> obtenerTodas();
    Area obtenerPorId(UUID id);
    void eliminarPorId(UUID id);
}