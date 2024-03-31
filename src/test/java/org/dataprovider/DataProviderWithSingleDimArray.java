package org.dataprovider;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DataProviderWithSingleDimArray {
	
	@Test(dataProvider = "data" )
	public void TestMethod(Object a) {
		System.out.println(a);
	}
	
	@DataProvider
	public Object[] data() {
		
		Object [] arr = new Object[] {
				1, "hello", 3 };
		return arr;
	}
}
