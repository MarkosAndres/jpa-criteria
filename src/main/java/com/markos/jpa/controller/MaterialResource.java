package com.markos.jpa.controller;

import com.markos.jpa.service.MaterialCriteria;
import com.markos.jpa.service.MaterialService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MaterialResource {

	@Autowired
	MaterialService materialService;

	@GetMapping("/test")
	public String search(MaterialCriteria materialCriteria) {

		return "ok";
	}

}
