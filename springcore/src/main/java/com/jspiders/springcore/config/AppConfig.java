package com.jspiders.springcore.config;

import java.util.ArrayList;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Scope;

@ComponentScan(basePackages = "com.jspiders.springcore")
public class AppConfig {

	@Bean
	@Scope("singleton")
	public ArrayList<Object> getList() {
		return new ArrayList<Object>();
	}

}
