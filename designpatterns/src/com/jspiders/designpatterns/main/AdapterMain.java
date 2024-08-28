package com.jspiders.designpatterns.main;

import com.jspiders.designpatterns.structural.Adapter;

public class AdapterMain {

	public static void main(String[] args) {

		Adapter adapter1 = new Adapter();
		adapter1.name = "Thar";
		adapter1.brand = "Mahindra";
		adapter1.price = 1200000.00;
		adapter1.sell();

		Adapter adapter2 = new Adapter();
		adapter2.name = "Scorpio";
		adapter2.brand = "Mahindra";
		adapter2.price = 2000000.00;
		adapter2.buy();

	}

}
