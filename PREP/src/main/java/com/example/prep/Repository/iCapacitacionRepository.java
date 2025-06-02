package com.example.prep.Repository;
import com.example.prep.Domain.Entity.Capacitacion;
import org.springframework.stereotype.Repository;
import java.util.UUID;

@Repository
public interface iCapacitacionRepository extends org.springframework.data.jpa.repository.JpaRepository<Capacitacion, UUID> {
}

