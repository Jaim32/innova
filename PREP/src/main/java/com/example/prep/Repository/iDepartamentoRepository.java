package com.example.prep.Repository;
import com.example.prep.Domain.Entity.Departamento;
import org.springframework.stereotype.Repository;
import java.util.UUID;


@Repository
public interface iDepartamentoRepository extends org.springframework.data.jpa.repository.JpaRepository<Departamento, UUID> {
}
