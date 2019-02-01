package com.markos.jpa.controller;

import com.markos.jpa.domain.Material;
import com.markos.jpa.service.MaterialFilter;
import com.markos.jpa.service.MaterialServiceCriteria;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class MaterialResource {

	@Autowired
	MaterialServiceCriteria materialServiceCriteria;

	@GetMapping("/test")
	public List<Material> search(MaterialFilter materialFilter, Pageable pageable) {
		return materialServiceCriteria.specificationContainsOnNumeric(materialFilter);
	}

}
