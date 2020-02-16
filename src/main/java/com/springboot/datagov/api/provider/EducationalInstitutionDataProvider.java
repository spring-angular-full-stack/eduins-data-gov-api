package com.springboot.datagov.api.provider;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import com.springboot.datagov.api.configuration.EducationalInstitutionConfiguration;

@Component
public class EducationalInstitutionDataProvider {
	
	Logger logger = LoggerFactory.getLogger(EducationalInstitutionDataProvider.class);
	
	private EducationalInstitutionConfiguration eduInsConfig;
	
	@Autowired
	EducationalInstitutionDataProvider(final EducationalInstitutionConfiguration eduInsConfigInstance) {
		this.eduInsConfig = eduInsConfigInstance;
	}
	
	public ResponseEntity<String> invokeGetEduInsApi() {
		
		ResponseEntity<String> response = null;
		
		String apiUrl = eduInsConfig.dataGovApiUrl();
		
		if (null == apiUrl || apiUrl.isEmpty()) {
			return response;
		}
		
		logger.debug("DEBUG::invokeGetEduInsApi->" + apiUrl);
		
		RestTemplate restTemplate = new RestTemplate();
		
		response = restTemplate.getForEntity(apiUrl, String.class);
		
		return response;
	}
}
