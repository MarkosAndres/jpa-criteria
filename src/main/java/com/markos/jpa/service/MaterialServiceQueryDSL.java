package com.markos.jpa.service;

import com.markos.jpa.domain.Material;
import com.markos.jpa.domain.QMaterial;
import com.markos.jpa.repository.MaterialRepository;
import com.querydsl.core.types.dsl.BooleanExpression;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MaterialServiceQueryDSL {

	@Autowired
	private MaterialRepository materialRepository;

	public Iterable<Material> sapLike(String sap) {
		QMaterial qMaterial = QMaterial.material;

		BooleanExpression predicate = qMaterial.sap.like(sap);

		return materialRepository.findAll(predicate);
	}
}
