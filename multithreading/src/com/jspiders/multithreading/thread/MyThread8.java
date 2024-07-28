package com.jspiders.multithreading.thread;

import com.jspiders.multithreading.resource.MyResource1;

public class MyThread8 extends Thread {

	private MyResource1 myResource1;

	public MyThread8() {
		super();
	}

	public MyThread8(MyResource1 myResource1) {
		super();
		this.myResource1 = myResource1;
	}

	@Override
	public void run() {
		for(int i = 1; i <= 100000; i++) {
			myResource1.increment();
		}
	}

}
