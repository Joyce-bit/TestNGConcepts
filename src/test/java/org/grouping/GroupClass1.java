package org.grouping;

import org.testng.annotations.*;


public class GroupClass1 {
	
	@Test(groups= {"windows.smoke"})
	public void test1() {
		System.out.println("windows.smoke Test");
	}
	
	@Test(groups= {"smoke" , "functional"})
	public void test2() {
		System.out.println("Smoke and Functional");
	}
	
	@Test(groups= {"windows.sanity"})
	public void test3() {
		System.out.println("Window.Sanity Test");
	}
	
	@Test(groups= {"windows.regression" })
	public void test4() {
		System.out.println("Windows.Regression Test");
	}

}
