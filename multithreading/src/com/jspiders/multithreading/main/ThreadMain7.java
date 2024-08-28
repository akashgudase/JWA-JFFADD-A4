package com.jspiders.multithreading.main;

import com.jspiders.multithreading.resource.MyResource1;
import com.jspiders.multithreading.thread.MyThread8;
import com.jspiders.multithreading.thread.MyThread9;

public class ThreadMain7 {

	public static void main(String[] args) {

		MyResource1 myResource1 = new MyResource1();

		MyThread8 myThread8 = new MyThread8(myResource1);
		MyThread9 myThread9 = new MyThread9(myResource1);

		myThread8.start();
		myThread9.start();
		
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		System.out.println(myResource1.getCount());

	}

}
