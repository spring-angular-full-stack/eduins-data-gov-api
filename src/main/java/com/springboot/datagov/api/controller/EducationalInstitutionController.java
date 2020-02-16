package com.springboot.datagov.api.controller;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.datagov.api.dto.EducationalInstitutionDto;
import com.springboot.datagov.api.service.EducationalInstitutionService;

@RestController
@RequestMapping("eduIns")
public class EducationalInstitutionController {

	private EducationalInstitutionService eduInsService;
	
	@Autowired
	EducationalInstitutionController(final EducationalInstitutionService eduInsServiceInstance) {
		this.eduInsService = eduInsServiceInstance;
	}
	
	@GetMapping("/healthCheck")
	public ResponseEntity<String> eduInsHealthCheck() {
		return new ResponseEntity<>("OK", HttpStatus.OK);
	}
	
	@GetMapping("/coimbatore")
	public Set<EducationalInstitutionDto> getEducationalInstitutionsInCoimbatore() {
		return this.eduInsService.getEducationalInstitutionsInCoimbatore();
	}
}
