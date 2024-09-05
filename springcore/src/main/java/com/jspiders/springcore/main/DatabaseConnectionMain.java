package com.jspiders.springcore.main;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.jspiders.springcore.bean.DatabaseConnection;

public class DatabaseConnectionMain {

	public static void main(String[] args) {

		ApplicationContext applicationContext = new ClassPathXmlApplicationContext("app_config.xml");
		DatabaseConnection bean = applicationContext.getBean(DatabaseConnection.class);
		System.out.println(bean);
		DatabaseConnection bean2 = applicationContext.getBean(DatabaseConnection.class);
		System.out.println(bean2);
		DatabaseConnection bean3 = applicationContext.getBean(DatabaseConnection.class);
		System.out.println(bean3);
		((ClassPathXmlApplicationContext) applicationContext).close();

	}

}
