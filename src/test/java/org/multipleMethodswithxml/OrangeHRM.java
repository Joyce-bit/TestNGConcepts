package org.multipleMethodswithxml;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class OrangeHRM {
	// We have multiple test method and all are executed in an order using xml file.
	WebDriver driver;
	
	@Test
	public void launchApp() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
	}
	
	@Test
	public void loginApp() {
		
		driver.findElement(By.xpath("(//input[@placeholder='Username'])[1]")).sendKeys("Admin");
		driver.findElement(By.xpath("(//input[@placeholder='Password'])[1]")).sendKeys("admin123");
		driver.findElement(By.xpath("(//button[normalize-space()='Login'])[1]")).click();
		
	}
	
	@Test
	public void MyInfo() {
		driver.findElement(By.xpath("(//span[normalize-space()='My Info'])[1]")).click();
		
	}
	
	@Test
	public void verifyMyInfo() throws InterruptedException {
		 WebElement verify = driver.findElement(By.xpath("(//div[@class='orangehrm-custom-fields'])[1]"));
		 verify.isDisplayed();
		 System.out.println("Info verified");
		 Thread.sleep(3000);
		 driver.quit();
	}
	
	@Test
	public void verifyLogin() {
		
		WebElement login = driver.findElement(By.xpath("(//h5[normalize-space()='Login'])[1]"));
		System.out.println(login.isDisplayed());
		System.out.println(login.getText());
		
	}

}
