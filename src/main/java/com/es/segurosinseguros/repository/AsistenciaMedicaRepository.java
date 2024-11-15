package com.es.segurosinseguros.repository;

import com.es.segurosinseguros.model.AsistenciaMedica;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Repositorio para la entidad {@link AsistenciaMedica}.
 * Proporciona métodos CRUD y otras operaciones personalizadas para la tabla "asistencia_medica".
 */
@Repository
public interface AsistenciaMedicaRepository extends JpaRepository<AsistenciaMedica, Long> {
}
