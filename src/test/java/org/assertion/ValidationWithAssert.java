package org.assertion;

import static org.testng.Assert.assertEquals;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;
import io.github.bonigarcia.wdm.WebDriverManager;

public class ValidationWithAssert {    
	
	WebDriver driver;
	
	@Test
	public void testGoogle() throws InterruptedException {
		
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.get("https://www.google.com");
		driver.findElement(By.xpath("(//textarea[@id='APjFqb'])[1]")).sendKeys("TestNG", Keys.ENTER);
		String expectedTitle = "TestNG - Google Search";
		String actualTitle = driver.getTitle();
		// Assert Validation
		assertEquals(expectedTitle, actualTitle, "Title is matched") ;
		Thread.sleep(3000);
		driver.close();
	}
	
}

