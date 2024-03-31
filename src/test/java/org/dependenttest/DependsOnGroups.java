package org.dependenttest;

import org.testng.annotations.Test;

public class DependsOnGroups {
	
	@Test(dependsOnGroups = {"smoke", "sanity", "regression"})
	public void mainTest() {
		System.out.println("This is main test");
	}
	
	@Test(groups="smoke")
	public void test1() {
		System.out.println("This is smoke");
	}
	
	@Test(groups="smoke")
	public void test2() {
		System.out.println("This is smoke");
	}
	
	@Test(groups="sanity")
	public void test3() {
	System.out.println("This is sanity");	
	}
	
	@Test(groups="regression", alwaysRun = true)
	public void test4() {
	System.out.println("This is regression");	
	}
}
