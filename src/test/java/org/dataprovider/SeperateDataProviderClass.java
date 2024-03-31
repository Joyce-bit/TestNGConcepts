package org.dataprovider;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class SeperateDataProviderClass {
	
	@DataProvider
	@Test
	public String[] datasupply() {
			
		String[] arr = new String[] {
			"John",
			"Joe",
			"James",
			"Joseph"
		};
		return arr;
	}
}
