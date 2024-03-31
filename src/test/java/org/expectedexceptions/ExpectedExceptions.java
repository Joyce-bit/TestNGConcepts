package org.expectedexceptions;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ExpectedExceptions {
	WebDriver driver;
	
	@Test(expectedExceptions = {NoSuchElementException.class, ArithmeticException.class})
	public void timeOut() {
		
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.get("https://www.google.com");
		
		driver.findElement(By.xpath("abc")).click();  // no such element in the google page
		int a = 10/0;  // arithmetic calculation is not possible
		System.out.println(a);
		driver.close();
		
	}

}
