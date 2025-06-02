package com.example.prep.Repository;

import com.example.prep.Domain.Entity.Area;
import org.springframework.stereotype.Repository;
import java.util.UUID;

@Repository
public interface iAreaRepository extends org.springframework.data.jpa.repository.JpaRepository<Area, UUID> {
}

