package com.jspiders.springcore.main;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.jspiders.springcore.bean.Software;
import com.jspiders.springcore.config.AppConfig;

public class BrowserMain {

	public static void main(String[] args) {

		ApplicationContext applicationContext = new AnnotationConfigApplicationContext(AppConfig.class);
		Software bean = applicationContext.getBean(Software.class);
		System.out.println(bean);
		((AnnotationConfigApplicationContext) applicationContext).close();

	}

}
