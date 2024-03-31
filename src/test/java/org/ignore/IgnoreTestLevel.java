package org.ignore;

import org.testng.annotations.*;


public class IgnoreTestLevel {
	@Ignore   
	// enabled attribute will not work as we have @Ignore on top of it
	@Test(enabled=true)  
	public void test1() {
		System.out.println("test1");
	}
	
	@Test
	public void test2() {
		System.out.println("test2");
	}
	@Ignore
	@Test
	public void test3() {
		System.out.println("test3");
	}

}
