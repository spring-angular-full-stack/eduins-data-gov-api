package com.springboot.datagov.api.service;

import java.util.Set;

import com.springboot.datagov.api.dto.EducationalInstitutionDto;

public interface EducationalInstitutionService {

	/**
	 * Get all Educational Institutions in Coimbatore
	 */
	
	Set<EducationalInstitutionDto> getEducationalInstitutionsInCoimbatore();
}
