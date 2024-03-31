package org.priority;

import org.testng.annotations.Test;

public class OrderOfExecutionwithPriority {
	
	@Test(priority=-1)  // priority with negative integer
	public void SignUp() {
		System.out.println("SignUp");
	}
	
	@Test // It picks up default value 0 for priority
	public void Login() {
	System.out.println("Login");	
	}
	
	@Test(priority=1)  // priority will positive integer
	public void SearchForTheFlight() {
		System.out.println("SearchForTheFlight");
	}
	
	@Test(priority=2)
	public void BookTheFlight() {
		System.out.println("BookTheFlight");
	}
	
	@Test(priority=3)
	public void saveTheTicket() {
		System.out.println("saveTheTicket");
	}
	
	@Test(priority=4)
	public void Logout() {
		System.out.println("Logout");
	}


}
