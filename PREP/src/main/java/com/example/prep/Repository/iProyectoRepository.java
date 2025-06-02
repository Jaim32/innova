package com.example.prep.Repository;
import com.example.prep.Domain.Entity.Proyecto;
import org.springframework.stereotype.Repository;
import java.util.UUID;

@Repository
public interface iProyectoRepository extends org.springframework.data.jpa.repository.JpaRepository<Proyecto, UUID> {
}
