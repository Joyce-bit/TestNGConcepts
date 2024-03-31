package org.dataprovider;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DataProviderWithMultiDimArray {
	
	@Test(dataProvider = "data" )
	public void TestMethod(String s) {
		System.out.println(s);
	}
	
	@DataProvider
	public Iterator<String> data() {
		
		Set<String> hashset = new HashSet();
		hashset.add("abcd");
		hashset.add("xyz");
		return hashset.iterator();
	
	}
}
