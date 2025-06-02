package com.example.prep.Repository;
import com.example.prep.Domain.Entity.Categoria;
import org.springframework.stereotype.Repository;
import java.util.UUID;


@Repository
public interface iCategoriaRepository extends org.springframework.data.jpa.repository.JpaRepository<Categoria, UUID> {
}