package com.example.prep.Service;

import com.example.prep.Domain.Entity.Evaluacion;

import java.util.List;
import java.util.UUID;

public interface iEvaluacionService {
    Evaluacion crearEvaluacion(Evaluacion evaluacion);
    List<Evaluacion> listarPorEmpleado(UUID idEmpleado);
    void eliminarPorId(UUID id);
}
