package org.assertion;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import io.github.bonigarcia.wdm.WebDriverManager;

public class SoftAssertion {
	
	// Soft Assertion validation by passing incorrect username to the login page of the Facebook
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
			
			// Create a object for the SoftAssert class for soft assertion validation
			SoftAssert softassert = new SoftAssert();
			
			//  Verify whether there is a change in Title - fail
			String actualTitle = driver.getTitle();  // title of application
			String expectedTitle = "Log in to Facebook";  // validating with incorrect title
			// add the  object name  in front of all the asserts as below
			softassert.assertEquals(actualTitle, expectedTitle );
			System.out.println("Title is matching");
			
			//Verify whether there is a change in URL - pass
			String actualURL = driver.getCurrentUrl();  // URL of the application
			String expectedURL = "https://www.facebook.com";  // validating with incorrect url
			softassert.assertNotEquals(expectedURL, actualURL );
			System.out.println("URL is different");
			
			// Verify whether the text input element for email is blank again - pass
			String actualText = driver.findElement(By.xpath("(//input[@id='email'])[1]")).getAttribute("value");
			String expectedText = "";  // validating the value of text input element for username 
			softassert.assertEquals(actualText, expectedText );
			System.out.println("Text is null");
			
			//Verify whether the border of the Text input element for email turns red - pass
			// inspect the element and go to the style in the side option and locate the css value 'border'.
			String actualBorder = driver.findElement(By.xpath("(//input[@id='email'])[1]")).getCssValue("border");  
			// inspect the element and go to the style in the side option and locate the css value of border '1px solid #f02849'
			// Convert the hex value #f02849 to RGB 'rgb(240, 40, 73)' using some sites
			String expectedBorder = "1px solid rgb(240, 40, 73)";  // validating the value of text input element for username 
			softassert.assertEquals(actualBorder, expectedBorder );
			System.out.println("Border turns to red");
			
			//Verify whether the error message is displayed under the text input element for email - pass
			String actualerrorMessage = driver.findElement(By.xpath("(//div[@class='_9ay7'])[1]")).getText();
			String expectederrorMessage = "The email address or mobile number you entered isn't connected to an account. Find your account and log in."; 
			softassert.assertEquals(actualerrorMessage, expectederrorMessage );
			System.out.println("Error Message is displayed sucessfully");
			
			driver.close();
			// assertAll method is used to check all the assertion and fail the asset which is mismatching and continue the execution
			softassert.assertAll();  
		}
	

}
