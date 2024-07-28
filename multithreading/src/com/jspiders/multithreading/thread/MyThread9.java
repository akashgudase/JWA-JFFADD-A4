package com.jspiders.multithreading.thread;

import com.jspiders.multithreading.resource.MyResource1;

public class MyThread9 extends Thread {

	private MyResource1 myResource1;

	public MyThread9() {
		super();
	}

	public MyThread9(MyResource1 myResource1) {
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
