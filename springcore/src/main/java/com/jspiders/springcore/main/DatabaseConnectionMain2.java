package com.jspiders.springcore.main;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.jspiders.springcore.bean.DatabaseConnection;

public class DatabaseConnectionMain2 {

	public static void main(String[] args) {

		ApplicationContext applicationContext = new ClassPathXmlApplicationContext("app_config.xml");
		DatabaseConnection bean = (DatabaseConnection) applicationContext.getBean("connection1");
		System.out.println(bean);
		DatabaseConnection bean2 = (DatabaseConnection) applicationContext.getBean("connection2");
		System.out.println(bean2);
		((ClassPathXmlApplicationContext) applicationContext).close();

	}

}
