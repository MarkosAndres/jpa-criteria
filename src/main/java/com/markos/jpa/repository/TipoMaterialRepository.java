package com.markos.jpa.repository;

import com.markos.jpa.domain.TiposMaterial;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TipoMaterialRepository extends JpaRepository<TiposMaterial, Long> {
}
