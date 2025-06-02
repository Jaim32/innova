package com.example.prep.Repository;
import org.springframework.stereotype.Repository;
import java.util.UUID;
import com.example.prep.Domain.Entity.Evaluacion;

@Repository
public interface iEvaluacionRepository extends org.springframework.data.jpa.repository.JpaRepository<Evaluacion, UUID> {
}
