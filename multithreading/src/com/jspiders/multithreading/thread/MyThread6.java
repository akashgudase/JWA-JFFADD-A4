package com.jspiders.multithreading.thread;

public class MyThread6 extends Thread{
	
	@Override
	public void run() {
		for (int i = 6; i <= 10; i++) {
			System.out.println(i);
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

}
