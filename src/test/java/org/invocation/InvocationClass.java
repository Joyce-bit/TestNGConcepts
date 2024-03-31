package org.invocation;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;
import io.github.bonigarcia.wdm.WebDriverManager;

public class InvocationClass {
	WebDriver driver;
	// invocationcount, invocationTimeOut, ThreadPoolSize are the attributes of @Test annotation
	// invocationCount will execute the test methods for the count we mention
	// invocationTimeout used to set a time limit of executing the test methods
	// threadPoolSize is used to execute the test methods parallelly based on the count
	@Test(invocationCount = 4, invocationTimeOut = 180000, threadPoolSize = 2)
	public void invocation() throws InterruptedException {
		
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("https://randomuser.me/");
		Thread.sleep(2000);
		
		driver.findElement(By.xpath("(//li[@data-label='name'])[1]")).click();
		String username = driver.findElement(By.xpath("(//p[@id='user_value'])[1]")).getText();
		System.out.println("Username : " + username);
		
		driver.findElement(By.xpath("(//li[@data-label='email'])[1]")).click();
		String email = driver.findElement(By.xpath("(//p[@id='user_value'])[1]")).getText();
		System.out.println("Email : " + email);
		Thread.sleep(2000);
		driver.close();
	}

}
