package com.jspiders.springcore.bean;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component(value = "Chrome")
@Scope("prototype")
//@Primary
public class Chrome implements Browser {

	@Override
	public String open() {
		return "Chrome is running";
	}

}
