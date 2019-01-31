package com.markos.jpa.repository;

import com.markos.jpa.domain.Material;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

public class MaterialRepositoryImpl implements MaterialRepositoryCustom {

	@PersistenceContext
	EntityManager entityManager;

	@Override
	public Material doSomething() {
		CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
		CriteriaQuery<Material> criteriaQuery = criteriaBuilder.createQuery(Material.class);

		Root<Material> root = criteriaQuery.from(Material.class);
		criteriaQuery.where(criteriaBuilder.equal(root.get("sap"), "3005101"));

		entityManager.createQuery(criteriaQuery).getSingleResult();

		return null;
	}
}
