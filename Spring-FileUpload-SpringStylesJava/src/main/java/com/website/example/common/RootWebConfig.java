package com.website.example.common;

import java.io.File;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@Configuration
@Import({FileConfig.class})
@ComponentScan(basePackages = {"com.website.example"})
@EnableWebMvc
//@ComponentScan(basePackages = {"com.local.example.beans", "com.local.example.advisor"})
public class RootWebConfig extends WebMvcConfigurerAdapter {

	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		registry.addResourceHandler("/static/**").addResourceLocations("file:c:" + File.separator + "temp/");
	}

}