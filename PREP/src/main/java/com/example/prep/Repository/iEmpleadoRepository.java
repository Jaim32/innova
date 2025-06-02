package com.example.prep.Repository;
import com.example.prep.Domain.Entity.Empleado;
import org.springframework.stereotype.Repository;
import java.util.UUID;

@Repository
public interface iEmpleadoRepository extends org.springframework.data.jpa.repository.JpaRepository<Empleado, UUID> {
}
