package org.grouping;

import org.testng.annotations.*;

public class GroupClass2 {
	@Test(groups= {"smoke"})
	public void test5() {
		System.out.println("smoke");
	}

	@Test(groups= {"windows.sanity", "functional" })
	public void test6() {
		System.out.println("windows.sanity and functional test");
	}

	@Test(groups= {"smoke" , "functional"})
	public void test7() {
		System.out.println("Smoke and Functional");
	}

	@Test(groups= {"windows.regression"})
	public void test8() {
		System.out.println("Windows.Regression Test");
	}

}
