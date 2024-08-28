package com.jspiders.multithreading.thread;

public class MyThread7 extends Thread{
	
	@Override
	public void run() {
		System.out.println("Id = " + this.threadId());
		System.out.println("Name = " + this.getName());
		System.out.println("Priority = " + this.getPriority());
	}

}
