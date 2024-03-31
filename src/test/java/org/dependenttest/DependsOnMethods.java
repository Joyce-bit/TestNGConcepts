package org.dependenttest;

import org.testng.annotations.Test;

public class DependsOnMethods {
	
	static String orderid = null;
	
	@Test
	public void GenerateOrderID() {
		orderid = "ORDER123";
		System.out.println("Order Id is generated: " + orderid);
	}
	
	@Test(dependsOnMethods = "GenerateOrderID")
	public void TrackWithOrderID() throws Exception {
		
		if(orderid!=null) {
			System.out.println("Track the product");
		}
		else
		{
			throw new Exception ("Invalid order id");
		}
	}
	
	@Test(dependsOnMethods = {"GenerateOrderID","TrackWithOrderID" })
	public void CancelWithOrderID() throws Exception {
		
		if(orderid!=null) {
			System.out.println("Cancel the product");
		}
		else
		{
			throw new Exception ("Invalid order id");
		}
	}
}
