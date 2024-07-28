package com.jspiders.multithreading.main;

import com.jspiders.multithreading.resource.Product;
import com.jspiders.multithreading.thread.Consumer;
import com.jspiders.multithreading.thread.Producer;

public class ProductMain {

	public static void main(String[] args) {

		Product product = new Product();

		Producer producer = new Producer(product);
		Consumer consumer = new Consumer(product);

		producer.start();
		consumer.start();

	}

}
