package com.example.prep.Service.ServiceImplementation;


import com.example.prep.Domain.Entity.Empleado;
import com.example.prep.Domain.Entity.Proyecto;
import com.example.prep.Domain.Entity.Tecnologia;
import com.example.prep.Repository.iEmpleadoRepository;
import com.example.prep.Repository.iProyectoRepository;
import com.example.prep.Repository.iTecnologiaRepository;
import com.example.prep.Service.iProyectoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class ProyectoServiceImpl implements iProyectoService {

    @Autowired
    private iProyectoRepository proyectoRepository;

    @Autowired
    private iEmpleadoRepository empleadoRepository;

    @Autowired
    private iTecnologiaRepository tecnologiaRepository;

    @Override
    public Proyecto crearProyecto(Proyecto proyecto) {
        return proyectoRepository.save(proyecto);
    }

    @Override
    public List<Proyecto> obtenerTodos() {
        return proyectoRepository.findAll();
    }

    @Override
    public Proyecto asignarTecnologia(UUID idProyecto, UUID idTecnologia) {
        Proyecto proyecto = proyectoRepository.findById(idProyecto).orElseThrow();
        Tecnologia tecnologia = tecnologiaRepository.findById(idTecnologia).orElseThrow();
        proyecto.getTecnologias().add(tecnologia);
        return proyectoRepository.save(proyecto);
    }

    @Override
    public Proyecto asignarEmpleado(UUID idProyecto, UUID idEmpleado) {
        Proyecto proyecto = proyectoRepository.findById(idProyecto).orElseThrow();
        Empleado empleado = empleadoRepository.findById(idEmpleado).orElseThrow();
        proyecto.getEmpleados().add(empleado);
        return proyectoRepository.save(proyecto);
    }

    @Override
    public Proyecto asignarLider(UUID idProyecto, UUID idEmpleadoLider) {
        Proyecto proyecto = proyectoRepository.findById(idProyecto).orElseThrow();
        Empleado lider = empleadoRepository.findById(idEmpleadoLider).orElseThrow();
        proyecto.setLider(lider);
        return proyectoRepository.save(proyecto);
    }
}
