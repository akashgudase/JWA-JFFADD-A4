package com.jspiders.multithreading.main;

import com.jspiders.multithreading.resource.MyResource2;
import com.jspiders.multithreading.thread.MyThread11;
import com.jspiders.multithreading.thread.MyThread12;

public class ThreadMain9 {

	public static void main(String[] args) {

		MyResource2 myResource2 = new MyResource2();

		MyThread11 myThread11 = new MyThread11(myResource2);
		MyThread12 myThread12 = new MyThread12(myResource2);

		myThread11.start();
		myThread12.start();

	}

}
