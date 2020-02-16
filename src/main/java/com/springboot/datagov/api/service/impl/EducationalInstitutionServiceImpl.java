package com.springboot.datagov.api.service.impl;

import java.util.HashSet;
import java.util.Set;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.springboot.datagov.api.converter.EducationalInstitutionDataConverter;
import com.springboot.datagov.api.dto.EducationalInstitutionDto;
import com.springboot.datagov.api.provider.EducationalInstitutionDataProvider;
import com.springboot.datagov.api.service.EducationalInstitutionService;

import lombok.Data;

@Service
@Data
public class EducationalInstitutionServiceImpl implements EducationalInstitutionService {

	Logger logger = LoggerFactory.getLogger(EducationalInstitutionServiceImpl.class);
	
	private EducationalInstitutionDataProvider eduInsDataProvider;
	
	private EducationalInstitutionDataConverter eduInsDataConverter;
	
	@Autowired
	public EducationalInstitutionServiceImpl(final EducationalInstitutionDataProvider eduInsDataProviderInstance,
			final EducationalInstitutionDataConverter eduInsDataConverterInstance) {
		super();
		this.eduInsDataProvider = eduInsDataProviderInstance;
		this.eduInsDataConverter = eduInsDataConverterInstance;
	}

	@Override
	public Set<EducationalInstitutionDto> getEducationalInstitutionsInCoimbatore() {
		
		ResponseEntity<String> response = eduInsDataProvider.invokeGetEduInsApi();
		
		logger.debug("DEBUG:: getEducationalInstitutionsInCoimbatore->" + response);
		
		Set<EducationalInstitutionDto> eduInsSet = new HashSet<>(10);
		
		if (null == response || !response.getStatusCode().is2xxSuccessful()) {
			return eduInsSet;
		}
		
		String responseBody = response.getBody();
		
		eduInsSet = eduInsDataConverter.parseEduInsResponse(responseBody);
		
		return eduInsSet;
	}

}