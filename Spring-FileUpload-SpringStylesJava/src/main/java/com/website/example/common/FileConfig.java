package com.website.example.common;

import java.io.File;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.Resource;
import org.springframework.web.multipart.MultipartResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@Configuration
public class FileConfig {
	
	@Bean
	public MultipartResolver multipartResolver() {
	    org.springframework.web.multipart.commons.CommonsMultipartResolver multipartResolver = new org.springframework.web.multipart.commons.CommonsMultipartResolver();
	    
	    multipartResolver.setMaxUploadSize(100000000);
	    multipartResolver.setMaxInMemorySize(100000000);	// 10MB
	    return multipartResolver;
	}
	
}