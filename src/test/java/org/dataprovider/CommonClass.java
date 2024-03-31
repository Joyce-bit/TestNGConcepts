package org.dataprovider;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;
import io.github.bonigarcia.wdm.WebDriverManager;

public class CommonClass {
	
	WebDriver driver;
	
	@Test(priority = 1, dataProvider = "orangeHRMData", dataProviderClass = CommonDataProvider.class)
	public void orangeHRM(String username, String password) throws InterruptedException {
		
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		driver.findElement(By.xpath("(//input[@placeholder='Username'])[1]")).sendKeys(username);
		driver.findElement(By.xpath("(//input[@placeholder='Password'])[1]")).sendKeys(password);
		Thread.sleep(3000);
		driver.close();
		
	}
	
	@Test(priority = 2, dataProvider = "facebookData", dataProviderClass = CommonDataProvider.class)
	public void facebook(String email, String pass) throws InterruptedException {
		
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("https://www.facebook.com/");
		driver.findElement(By.xpath("(//input[@id='email'])[1]")).sendKeys(email);
		driver.findElement(By.xpath("(//input[@id='pass'])[1]")).sendKeys(pass);
		Thread.sleep(3000);
		driver.close();
		
	}

}
