package com.example.prep.Service.ServiceImplementation;

import com.example.prep.Domain.Entity.Evaluacion;
import com.example.prep.Repository.iEvaluacionRepository;
import com.example.prep.Service.iEvaluacionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class EvaluacionServiceImpl implements iEvaluacionService {

    @Autowired
    private iEvaluacionRepository evaluacionRepository;

    @Override
    public Evaluacion crearEvaluacion(Evaluacion evaluacion) {
        return evaluacionRepository.save(evaluacion);
    }

    @Override
    public List<Evaluacion> listarPorEmpleado(UUID idEmpleado) {
        return evaluacionRepository.findByEmpleadoId(idEmpleado);
    }

    @Override
    public void eliminarPorId(UUID id) {
        evaluacionRepository.deleteById(id);
    }
}
