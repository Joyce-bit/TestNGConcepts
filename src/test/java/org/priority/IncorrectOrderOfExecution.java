package org.priority;

import org.testng.annotations.Test;

public class IncorrectOrderOfExecution {
	
	@Test
	public void SignUp() {
		System.out.println("SignUp");
	}
	
	@Test
	public void Login() {
	System.out.println("Login");	
	}
	
	@Test
	public void SearchForTheFlight() {
		System.out.println("SearchForTheFlight");
	}
	
	@Test
	public void BookTheFlight() {
		System.out.println("BookTheFlight");
	}
	
	@Test
	public void saveTheTicket() {
		System.out.println("saveTheTicket");
	}
	
	@Test
	public void Logout() {
		System.out.println("Logout");
	}

}
