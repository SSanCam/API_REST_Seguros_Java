package com.es.segurosinseguros.repository;

import com.es.segurosinseguros.model.Seguro;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Repositorio para la entidad {@link Seguro}.
 * Proporciona métodos CRUD y otras operaciones personalizadas para la tabla "seguros".
 */
@Repository
public interface SeguroRepository extends JpaRepository<SeguroRepository, Long> {
}
