package com.example.prep.Repository;
import com.example.prep.Domain.Entity.Cliente;
import org.springframework.stereotype.Repository;
import java.util.UUID;


@Repository
public interface iClienteRepository extends org.springframework.data.jpa.repository.JpaRepository<Cliente, UUID> {
}