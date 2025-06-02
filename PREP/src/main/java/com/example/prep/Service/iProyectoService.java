package com.example.prep.Service;

import com.example.prep.Domain.Entity.Proyecto;
import java.util.UUID;

import java.util.List;

public interface iProyectoService {
    Proyecto crearProyecto(Proyecto proyecto);
    List<Proyecto> obtenerTodos();
    Proyecto asignarEmpleado(UUID idProyecto,UUID idEmpleado);
    Proyecto asignarTecnologia(UUID idProyecto, UUID idTecnologia);
    Proyecto asignarLider(UUID idProyecto, UUID idEmpleadolider);

}
