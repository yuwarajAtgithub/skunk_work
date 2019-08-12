package com.practice.test;

import static org.junit.Assert.*;

import java.util.HashMap;
import java.util.Map;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class TestDebug {

	Map<Integer, String> theNumbers = null;
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
		// Dummy Comment 1
		theNumbers = new HashMap<>();
		theNumbers.put(1, "One");
		theNumbers.put(2, "Two");
		theNumbers.put(3, "Three");
		theNumbers.put(4, "Four");
		theNumbers.put(5, "Five");
		theNumbers.put(6, "Six");
		theNumbers.put(7, "Seven");
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void test() {
		System.out.println("Start");
		Thread t = new Thread(new Runnable() {
			
			@Override
			public void run() {
				try {
					synchronized (theNumbers) {
						theNumbers.put(8, "3");
						theNumbers.wait(10);
					
						theNumbers.put(9, "93");
						theNumbers.wait(10);
						theNumbers.put(10, "103");
						theNumbers.wait(10);
						theNumbers.put(11, "113");
						System.out.println("Thread Complete");
					}
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
		t.start();
		synchronized (theNumbers) {
			try {
				theNumbers.wait(20);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		
		evaluate();
		fail("Not yet implemented");
	}

	private void evaluate() {
		int dataVar = 7;
		synchronized (theNumbers) {
			try {
				theNumbers.wait(20);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		System.out.println("Entering....");
		if (dataVar < 8) {
			System.out.println("Normal....");
		} else {
			System.out.println("Updated....");
		}
		System.out.println("Evaluate  Complete");
	}

}
