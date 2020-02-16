package com.springboot.datagov.api.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class EducationalInstitutionDto {

	private Double propertyId;
	
	private String educationInstitutionCategory;
	
	private String educationInstitutionMaintainedBy;
	
	private String educationInstitutionName;
	
	private Double wardNumber;
	
	private String address;
	
	private Double lengthMtr;
	
	private Double areaMtr;
	
	private String educationInstitutionId;
	
}
