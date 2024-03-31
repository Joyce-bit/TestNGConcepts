package org.ignore;

import org.testng.annotations.*;

@Ignore  // Ignore all the test methods at the class level
public class IgnoreClassLevel {
	
	
	@Test 
	public void test1() {
		System.out.println("test1");
	}
	
	@Test
	public void test2() {
		System.out.println("test2");
	}
	
	@Test
	public void test3() {
		System.out.println("test3");
	}

}
