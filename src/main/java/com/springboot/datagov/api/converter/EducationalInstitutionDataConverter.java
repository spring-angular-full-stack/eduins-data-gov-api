package com.springboot.datagov.api.converter;

import java.util.HashSet;
import java.util.Set;

import org.json.JSONArray;
import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import com.springboot.datagov.api.dto.EducationalInstitutionDto;

import lombok.Data;

@Component
@Data
public class EducationalInstitutionDataConverter {

	Logger logger = LoggerFactory.getLogger(EducationalInstitutionDataConverter.class);
	
	public Set<EducationalInstitutionDto> parseEduInsResponse(String responseBody) {
		
		if (StringUtils.isEmpty(responseBody)) {
			return new HashSet<>(1);
		}
		
		JSONObject jsonObject = new JSONObject(responseBody);
		
		if (jsonObject.isEmpty()) {
			return new HashSet<>(1);
		}
		
		JSONArray fieldArray = jsonObject.getJSONArray("field");
		
		logger.debug("DEBUG::parseEduInsResponse->fieldArray->" + fieldArray);
		
		JSONArray recordsArray = jsonObject.getJSONArray("records");
		
		logger.debug("DEBUG::parseEduInsResponse->recordsArray->" + recordsArray);
		
		if (null == recordsArray || recordsArray.isEmpty()) {
			return new HashSet<>(1);
		}
		
		Set<EducationalInstitutionDto> dtoSet = new HashSet<>(recordsArray.length());
		
		EducationalInstitutionDto dtoObject = null;
		
		for (Object arrayObject : recordsArray) {
			
			if (arrayObject instanceof JSONObject) {
				dtoObject = new EducationalInstitutionDto();
				logger.debug("arrayObject->" + arrayObject);
				dtoObject.setAddress(((JSONObject) arrayObject).getString("address"));
				dtoObject.setEducationInstitutionName(((JSONObject) arrayObject).getString("education_institution_name"));
				dtoSet.add(dtoObject);
			}
		}
		
		return dtoSet;
		
	}
}
