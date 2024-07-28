package com.jspiders.multithreading.thread;

public class MyThread10 extends Thread{
	
	@SuppressWarnings("removal")
	@Override
	public void run() {
		for(int i = 1; i <= 10; i++) {
			if(i == 5) {
				this.stop();
			}
			System.out.println("Hello from MyThread10");
		}
	}

}
