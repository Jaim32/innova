package com.example.prep.Service;
import com.example.prep.Domain.Entity.Tecnologia;

import java.util.List;
import java.util.UUID;

public interface iTecnologiaService {
    Tecnologia crearTecnologia(Tecnologia tecnologia);
    List<Tecnologia> obtenerTodas();
    Tecnologia obtenerPorId(UUID id);
    void eliminarPorId(UUID id);
}
