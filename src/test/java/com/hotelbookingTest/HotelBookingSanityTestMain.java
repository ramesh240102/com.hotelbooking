package com.hotelbookingTest;

import org.testng.TestListenerAdapter;
import org.testng.TestNG;

public class HotelBookingSanityTestMain {

	public static void main(String[] args) {
	
		TestListenerAdapter tla = new TestListenerAdapter();
		TestNG testng = new TestNG();
		testng.setTestClasses(new Class[] { HotelBookingSanityTest.class });
		testng.addListener(tla);
		testng.run();
	}

}
