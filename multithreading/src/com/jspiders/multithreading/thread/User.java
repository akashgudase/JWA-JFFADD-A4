package com.jspiders.multithreading.thread;

import com.jspiders.multithreading.resource.FacebookServer;

public class User extends Thread {

	private FacebookServer facebookServer;

	public User() {
		super();
	}

	public User(FacebookServer facbookServer) {
		super();
		this.facebookServer = facbookServer;
	}

	@Override
	public void run() {
		facebookServer.welcome();
	}

}
