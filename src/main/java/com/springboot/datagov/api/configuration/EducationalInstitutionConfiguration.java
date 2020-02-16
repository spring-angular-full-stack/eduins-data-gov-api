package com.springboot.datagov.api.configuration;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import lombok.Data;

@Configuration
@Data
public class EducationalInstitutionConfiguration {

	@Value("${eduInsConfig.url}")
	private String url;

	@Value("${eduInsConfig.apiKey}")
	private String apiKey;
	
	@Value("${eduInsConfig.format}")
	private String format;
	
	@Value("${eduInsConfig.offset}")
	private String offset;
	
	@Value("${eduInsConfig.limit}")
	private String limit;
	
	@Bean
	public String dataGovApiUrl() {
		StringBuilder finalUrlBuilder = new StringBuilder();
		
		finalUrlBuilder.append(this.url)
					   .append("api-key=")
					   .append(this.apiKey)
					   .append("&format=")
					   .append(this.format)
					   .append("&offset=")
					   .append(this.offset)
					   .append("&limit=")
					   .append(this.limit);
		
		return finalUrlBuilder.toString();
	}
	
}
