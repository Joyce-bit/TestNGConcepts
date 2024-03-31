package org.timeout;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TimeOut {
	
	WebDriver driver;
	
	@Test(timeOut = 20000)
	public void timeOut() {
		
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		
		driver.findElement(By.xpath("(//input[@placeholder='Username'])[1]")).sendKeys("Admin");
		driver.findElement(By.xpath("(//input[@placeholder='Password'])[1]")).sendKeys("admin123");
		driver.findElement(By.xpath("(//button[normalize-space()='Login'])[1]")).click();
		
	}
	
}
