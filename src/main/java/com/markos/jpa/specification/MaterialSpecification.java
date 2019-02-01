package com.markos.jpa.specification;

import com.markos.jpa.domain.Material;
import com.markos.jpa.domain.Material_;
import org.springframework.data.jpa.domain.Specification;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

public class MaterialSpecification implements Specification<Material> {

	@Override
	public Predicate toPredicate(Root<Material> root, CriteriaQuery<?> criteriaQuery, CriteriaBuilder cb) {
		return cb.equal(root.get(Material_.sap), "2003216");
	}
}
