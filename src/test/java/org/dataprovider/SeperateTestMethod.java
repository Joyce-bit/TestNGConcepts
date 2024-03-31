package org.dataprovider;

import org.testng.annotations.Test;

public class SeperateTestMethod {
	
	
	@Test(dataProvider = "datasupply", dataProviderClass = SeperateDataProviderClass.class)
	public void testMethod(String s) {
		
		System.out.println(s);
	}

}
