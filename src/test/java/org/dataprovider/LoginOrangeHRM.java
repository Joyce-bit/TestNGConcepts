package org.dataprovider;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import io.github.bonigarcia.wdm.WebDriverManager;

public class LoginOrangeHRM {
	
	WebDriver driver;
	
	@Test(dataProvider="loginData")
	public void loginTest(String userName, String password) throws InterruptedException {
		
		SoftAssert softassert = new SoftAssert();
		
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		driver.findElement(By.xpath("(//input[@placeholder='Username'])[1]")).sendKeys(userName);
		driver.findElement(By.xpath("(//input[@placeholder='Password'])[1]")).sendKeys(password);
		driver.findElement(By.xpath("(//button[normalize-space()='Login'])[1]")).click();
		
		boolean display = driver.findElement(By.xpath("(//h6[normalize-space()='Dashboard'])[1]")).isDisplayed();
		softassert.assertTrue(display);
		if(display = true) {
			System.out.println("Login successful");
		}
		else {
			System.out.println("Invalid Credentials");
		}
		Thread.sleep(5000);
		driver.close();
	}
		
	@DataProvider()
	public Object[][] loginData() {
		Object[][] data = new Object[2][2];
		data[0][0] = "Admin";   // valid username
		data[0][1] = "admin123";  // valid password
		
		data[1][0] = "Admin";  // valid username
		data[1][1] = "123";  // invalid password
		return data;
	}
}
