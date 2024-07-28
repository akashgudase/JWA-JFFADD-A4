package com.jspiders.multithreading.main;

import com.jspiders.multithreading.resource.FacebookServer;
import com.jspiders.multithreading.thread.User;

public class FacebookMain {

	public static void main(String[] args) {

		FacebookServer facebookServer = new FacebookServer();

		User user1 = new User(facebookServer);
		user1.setName("Ramesh");
		User user2 = new User(facebookServer);
		user2.setName("Suresh");
		User user3 = new User(facebookServer);
		user3.setName("Mahesh");
		User user4 = new User(facebookServer);
		user4.setName("Umesh");

		user1.start();
		user2.start();
		user3.start();
		user4.start();

	}

}
