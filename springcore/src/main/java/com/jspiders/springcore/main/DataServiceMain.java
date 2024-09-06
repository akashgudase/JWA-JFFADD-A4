package com.jspiders.springcore.main;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.jspiders.springcore.bean.DataService;

public class DataServiceMain {

	public static void main(String[] args) {

		ApplicationContext applicationContext = new AnnotationConfigApplicationContext("com.jspiders.springcore");
		DataService bean = applicationContext.getBean(DataService.class);
		System.out.println(bean);
		((AnnotationConfigApplicationContext) applicationContext).close();

	}

}
