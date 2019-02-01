package com.markos.jpa.controller;

import com.markos.jpa.domain.Material;
import com.markos.jpa.service.MaterialCriteria;
import com.markos.jpa.service.MaterialService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class MaterialResource {

	@Autowired
	MaterialService materialService;

	@GetMapping("/test")
	public List<Material> search(MaterialCriteria materialCriteria, Pageable pageable) {

		return materialService.specificationContainsOnNumeric(materialCriteria);
	}

}
