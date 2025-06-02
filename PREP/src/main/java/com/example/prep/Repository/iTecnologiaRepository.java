package com.example.prep.Repository;
import com.example.prep.Domain.Entity.Tecnologia;
import org.springframework.stereotype.Repository;
import java.util.UUID;

@Repository
public interface iTecnologiaRepository extends org.springframework.data.jpa.repository.JpaRepository<Tecnologia, UUID> {
}