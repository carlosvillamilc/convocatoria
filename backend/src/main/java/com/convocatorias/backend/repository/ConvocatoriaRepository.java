package com.convocatorias.backend.repository;

import com.convocatorias.backend.entity.Convocatoria;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
@Repository
public interface ConvocatoriaRepository extends JpaRepository<Convocatoria, Integer> {
    Optional<Convocatoria> findByNombre(String nombre);

    boolean existsByNombre(String nombre);
}
