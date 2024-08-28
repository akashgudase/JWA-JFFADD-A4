package com.jspiders.multithreading.main;

import com.jspiders.multithreading.thread.MyThread5;
import com.jspiders.multithreading.thread.MyThread6;

public class ThreadMain5 {
	
	public static void main(String[] args) {
		
		MyThread5 myThread5 = new MyThread5();
		MyThread6 myThread6 = new MyThread6();
		
		long start = System.currentTimeMillis();
		myThread5.start();
		myThread6.start();
		try {
			Thread.sleep(6000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		long end = System.currentTimeMillis();
		System.out.println(end - start);
		
	}

}
