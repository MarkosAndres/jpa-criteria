package com.markos.jpa.service;

import com.markos.jpa.domain.Material;
import com.markos.jpa.domain.QMaterial;
import com.markos.jpa.domain.QTiposMaterial;
import com.markos.jpa.repository.MaterialRepository;
import com.querydsl.core.BooleanBuilder;
import com.querydsl.core.types.dsl.BooleanExpression;
import com.querydsl.jpa.impl.JPAQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Service
public class MaterialServiceQueryDSL {

	@Autowired
	private MaterialRepository materialRepository;

	@PersistenceContext
	EntityManager entityManager;

	public Iterable<Material> sapLike(String sap) {
		QMaterial qMaterial = QMaterial.material;
		BooleanExpression predicate = qMaterial.sap.like(sap);

		return materialRepository.findAll(predicate);
	}

	public Iterable<Material> join(String sap) {
		QMaterial material = QMaterial.material;
		QTiposMaterial tipo = QTiposMaterial.tiposMaterial;

//		JPAQuery query = new JPAQuery(entityManager);
//		query
//				.from(material)
//				.join(material.tipo, tipo)
//		.on(tipo.tipo.eq("Herramienta"));

		BooleanExpression b = material.tipo.tipo.eq("Herramienta");


		return materialRepository.findAll(b);
	}
}
