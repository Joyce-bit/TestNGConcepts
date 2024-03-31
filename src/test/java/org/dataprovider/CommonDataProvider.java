package org.dataprovider;

import org.testng.annotations.DataProvider;

public class CommonDataProvider {
	
	@DataProvider
	public String[][] orangeHRMData() {
		
		String [][] arr = new String[][] {
			
			{"Admin", "admin123"}
		};
		return arr;
		
	}
	
	@DataProvider
	public String[][] facebookData() {
		
		String[][] arr1 = new String[][] {
			{"tutorial" ,  "123"}
		};
		return arr1;
	}
	
	
	

}
