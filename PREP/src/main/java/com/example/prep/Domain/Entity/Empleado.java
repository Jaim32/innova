package com.example.prep.Domain.Entity;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Empleado {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Column(nullable = false)
    private String nombre;

    @Column(nullable = false)
    private String apellido;

    @Column(nullable = false, unique = true)
    private String email;

    @Column(nullable = false)
    private LocalDate fechaIngreso;

    @Column(nullable = false)
    private String puesto;

    @ManyToOne
    @JoinColumn(name = "id_departamento", nullable = false, foreignKey = @ForeignKey(name = "fk_empleado_departamento"))
    private Departamento departamento;

    @ManyToMany
    @JoinTable(name = "empleado_proyecto",
            joinColumns = @JoinColumn(name = "empleado_id"),
            inverseJoinColumns = @JoinColumn(name = "proyecto_id"))
    private List<Proyecto> proyectos;

    @ManyToMany
    @JoinTable(name = "empleado_mentor",
            joinColumns = @JoinColumn(name = "empleado_id"),
            inverseJoinColumns = @JoinColumn(name = "mentor_id"))
    private List<Empleado> mentores;

    @ManyToMany(mappedBy = "mentores")
    private List<Empleado> mentorados;

    @ManyToMany
    @JoinTable(name = "empleado_capacitacion",
            joinColumns = @JoinColumn(name = "empleado_id"),
            inverseJoinColumns = @JoinColumn(name = "capacitacion_id"))
    private List<Capacitacion> capacitaciones;

    @OneToMany(mappedBy = "empleado")
    private List<Evaluacion> evaluaciones;
}


