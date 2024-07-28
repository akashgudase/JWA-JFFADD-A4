package com.jspiders.multithreading.thread;

import com.jspiders.multithreading.resource.MyResource2;

public class MyThread12 extends Thread {

	private MyResource2 myResource2;

	public MyThread12() {
		super();
	}

	public MyThread12(MyResource2 myResource2) {
		super();
		this.myResource2 = myResource2;
	}

	@Override
	public void run() {
		synchronized (myResource2.r2) {
			System.out.println("Lock applied on Resource2 by MyThread12");
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			synchronized (myResource2.r1) {
				System.out.println("Lock applied on Resource1 by MyThread12");
			}
		}
	}

}
