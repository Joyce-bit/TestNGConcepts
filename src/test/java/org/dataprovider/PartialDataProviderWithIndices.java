package org.dataprovider;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class PartialDataProviderWithIndices {
	
	@Test(dataProvider = "Data")
	public void testMethod(String s) {
		System.out.println(s);
	}
	
	@DataProvider(indices = {0,2})
	@Test
	public String[] Data() {
		
		String[] arr = new String[] {
				"John",
				"Joseph",
				"James",
				"Joe"
		};
		return arr;
		
	}
}
