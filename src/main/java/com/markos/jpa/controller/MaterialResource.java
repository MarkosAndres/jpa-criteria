package com.markos.jpa.controller;

import com.markos.jpa.domain.Material;
import com.markos.jpa.service.MaterialFilter;
import com.markos.jpa.service.MaterialServiceCriteria;
import com.markos.jpa.service.MaterialServiceQueryDSL;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class MaterialResource {

	@Autowired
	MaterialServiceCriteria materialServiceCriteria;

	@Autowired
	MaterialServiceQueryDSL materialServiceQueryDSL;

	@GetMapping("/test-criteria")
	public List<Material> searchCriteria(MaterialFilter materialFilter, Pageable pageable) {
		return materialServiceCriteria.specificationContainsOnNumeric(materialFilter);
	}

	@GetMapping("/test-querydsl")
	public Iterable<Material> searchQueryDsl(MaterialFilter materialFilter, Pageable pageable) {
		return materialServiceQueryDSL.sapLike("%175%");
	}

	@GetMapping("/test-querydsl-join")
	public Iterable<Material> searchQueryDslJoin(MaterialFilter materialFilter, Pageable pageable) {
		return materialServiceQueryDSL.join("%175%");
	}

}
