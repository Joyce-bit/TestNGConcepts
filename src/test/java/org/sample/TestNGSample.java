package org.sample;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;
import io.github.bonigarcia.wdm.WebDriverManager;

public class TestNGSample {    
	// We have two test methods in this test class however TestNG will execute this in alphabetical order
	WebDriver driver;
	
	@Test
	public void testGoogle() throws InterruptedException {
		
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.get("https://www.google.com");
		driver.findElement(By.xpath("(//textarea[@id='APjFqb'])[1]")).sendKeys("TestNG", Keys.ENTER);
		System.out.println(driver.getTitle());
		Thread.sleep(3000);
		driver.close();
	}
	
	@Test
	public void testFacebook() throws InterruptedException {
		
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.get("https://www.facebook.com");
		driver.findElement(By.xpath("(//input[@id='email'])[1]")).sendKeys("red", Keys.ENTER);
		System.out.println(driver.getTitle());
		Thread.sleep(3000);
		driver.close();
	}
}

