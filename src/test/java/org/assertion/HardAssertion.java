package org.assertion;

import static org.testng.Assert.assertEquals;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;
import io.github.bonigarcia.wdm.WebDriverManager;


public class HardAssertion {
	
	// Hard Assertion validation by passing incorrect username to the login page of the Facebook
	/*
	 * Verifications
	 * 1. Verify whether there is a change in Title
	 * 2. Verify whether there is a change in URL
	 * 3. Verify whether the text input element for email is blank again
	 * 4. Verify whether the border of the Text input element for email turns red
	 * 5. Verify whether the error message is displayed under the text input element for email
	 */
	
	WebDriver driver;
	
	@Test
	public void testFacebook( ) throws InterruptedException {
		
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.get("https://www.facebook.com");
		driver.findElement(By.xpath("(//input[@id='email'])[1]")).sendKeys("tutorial", Keys.ENTER);
		Thread.sleep(3000);
		
		//  Verify whether there is a change in Title
		String actualTitle = driver.getTitle();  // title of application
		String expectedTitle = "Log to Facebook";  // validating with incorrect title
		assertEquals(expectedTitle, actualTitle , "Title is mismatched");
		
		//Verify whether there is a change in URL
		String actualURL = driver.getCurrentUrl();  // URL of the application
		String expectedURL = "https://www.facebook.com";  // validating with incorrect url
		assertEquals(expectedURL, actualURL , "URL is mismatched");
		
		// Verify whether the text input element for email is blank again
		String actualText = driver.findElement(By.xpath("(//input[@id='email'])[1]")).getAttribute("value");
		String expectedText = "";  // validating the value of text input element for username 
		assertEquals(actualText, expectedText , "Text is mismatched");
		
		//Verify whether the border of the Text input element for email turns red
		// inspect the element and go to the style in the side option and locate the css value 'border'.
		String actualBorder = driver.findElement(By.xpath("(//input[@id='email'])[1]")).getCssValue("border");  
		// inspect the element and go to the style in the side option and locate the css value of border '1px solid #f02849'
		// Convert the hex value #f02849 to RGB 'rgb(240, 40, 73)' using some sites
		String expectedBorder = "1px solid rgb(240, 40, 73)";  // validating the value of text input element for username 
		assertEquals(actualBorder, expectedBorder , "Border of Text input element for username is mismatched");
		
		//Verify whether the error message is displayed under the text input element for email.
		String actualerrorMessage = driver.findElement(By.xpath("(//div[@class='_9ay7'])[1]")).getText();
		String expectederrorMessage = "The email address or mobile number you entered isn't connected to an account. Find your account and log in."; 
		assertEquals(actualerrorMessage, expectederrorMessage , "Error Message is mismatch");
		
		
		driver.close();
	}
	
}
