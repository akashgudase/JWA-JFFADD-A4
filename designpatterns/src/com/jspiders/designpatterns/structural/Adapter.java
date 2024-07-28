package com.jspiders.designpatterns.structural;

public class Adapter extends Car implements Operation {

	@Override
	public void sell() {
		System.out.println("Car is sold with specifications : ");
		System.out.println(name);
		System.out.println(brand);
		System.out.println(price);
	}

	@Override
	public void buy() {
		System.out.println("Car is bought with specifications : ");
		System.out.println(name);
		System.out.println(brand);
		System.out.println(price);
	}

}
