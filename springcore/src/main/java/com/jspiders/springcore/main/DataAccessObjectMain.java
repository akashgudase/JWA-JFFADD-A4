package com.jspiders.springcore.main;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.jspiders.springcore.bean.DataAccessObject;

public class DataAccessObjectMain {

	public static void main(String[] args) {

		ApplicationContext applicationContext = new ClassPathXmlApplicationContext("app_config.xml");
		DataAccessObject bean = (DataAccessObject) applicationContext.getBean("dao1");
		System.out.println(bean);
		DataAccessObject bean2 = (DataAccessObject) applicationContext.getBean("dao2");
		System.out.println(bean2);
		((ClassPathXmlApplicationContext) applicationContext).close();

	}

}
