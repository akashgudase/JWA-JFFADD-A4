package com.jspiders.springcore.bean;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component(value = "Firefox")
@Scope("prototype")
//@Primary
public class FireFox implements Browser {

	@Override
	public String open() {
		return "Firefox is running";
	}

}
