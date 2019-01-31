package com.markos.jpa.repository;

import com.markos.jpa.domain.Material;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MaterialRepository extends JpaRepository<Material, Long>, MaterialRepositoryCustom {

}
