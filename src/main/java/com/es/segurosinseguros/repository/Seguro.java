package com.es.segurosinseguros.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface Seguro extends JpaRepository<Seguro, Long> {
}
