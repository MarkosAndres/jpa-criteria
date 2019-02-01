package com.markos.jpa.controller;

import com.markos.jpa.service.MaterialService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Facade {

	@Autowired
	MaterialService materialService;

	@GetMapping("/test")
	public String search() {


		return "ok";
	}

}
