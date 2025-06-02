package com.example.prep.Domain.Entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Proyecto {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Column(nullable = false)
    private String codigo;

    @Column(nullable = false)
    private String nombre;

    @ManyToOne
    @JoinColumn(name = "id_area", nullable = false, foreignKey = @ForeignKey(name = "fk_proyecto_area"))
    private Area area;

    @ManyToOne
    @JoinColumn(name = "id_categoria", nullable = false, foreignKey = @ForeignKey(name = "fk_proyecto_categoria"))
    private Categoria categoria;

    @ManyToOne
    @JoinColumn(name = "id_cliente", nullable = false, foreignKey = @ForeignKey(name = "fk_proyecto_cliente"))
    private Cliente cliente;

    @ManyToOne
    @JoinColumn(name = "id_lider", nullable = false, foreignKey = @ForeignKey(name = "fk_proyecto_lider"))
    private Empleado lider;

    @ManyToMany
    @JoinTable(name = "proyecto_tecnologia",
            joinColumns = @JoinColumn(name = "proyecto_id"),
            inverseJoinColumns = @JoinColumn(name = "tecnologia_id"))
    private List<Tecnologia> tecnologias;
}
