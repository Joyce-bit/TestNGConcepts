package org.screenshots;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.testng.annotations.*;
import org.testng.asserts.SoftAssert;

@Listeners(ListenerClassForScreenshot.class)
public class ScreenShotsFailedTest extends BaseClassForScreenshot {

	@Test
	public void testGoogle() throws InterruptedException {

		SoftAssert softassert = new SoftAssert();

		driver.get("https://www.google.com");
		driver.findElement(By.xpath("(//textarea[@id='APjFqb'])[1]")).sendKeys("TestNG", Keys.ENTER);

		String actualTitle = driver.getTitle();
		String expectedTitle = "TestNG - Google Search";   // This method will pass through
		softassert.assertEquals(actualTitle, expectedTitle, "Title is matched");
		softassert.assertAll();
	}

	@Test
	public void testFacebook() throws InterruptedException {

		driver.get("https://www.facebook.com");
		// wrong email is given to intentionally fail the method
		driver.findElement(By.xpath("(//input[@id='email'])[1]")).sendKeys("tutorial", Keys.ENTER);
		Thread.sleep(3000);

		// Create a object for the SoftAssert class for soft assertion validation
		SoftAssert softassert = new SoftAssert();

		// Verify whether there is a change in Title - fail
		String actualTitle = driver.getTitle(); // title of application
		String expectedTitle = "Log in Facebook"; // validating with incorrect title
		// add the object name in front of all the asserts as below
		softassert.assertEquals(actualTitle, expectedTitle);
		System.out.println("Title is matching");

		// Verify whether there is a change in URL - pass
		String actualURL = driver.getCurrentUrl(); // URL of the application
		String expectedURL = "https://www.facebook.com"; // validating with incorrect url
		softassert.assertNotEquals(expectedURL, actualURL);
		System.out.println("URL is different");

		// Verify whether the text input element for email is blank again - pass
		String actualText = driver.findElement(By.xpath("(//input[@id='email'])[1]")).getAttribute("value");
		String expectedText = ""; // validating the value of text input element for username
		softassert.assertEquals(actualText, expectedText);
		System.out.println("Text is null");

		// Verify whether the border of the Text input element for email turns red -
		// pass
		// inspect the element and go to the style in the side option and locate the css
		// value 'border'.
		String actualBorder = driver.findElement(By.xpath("(//input[@id='email'])[1]")).getCssValue("border");
		// inspect the element and go to the style in the side option and locate the css
		// value of border '1px solid #f02849'
		// Convert the hex value #f02849 to RGB 'rgb(240, 40, 73)' using some sites
		String expectedBorder = "1px solid rgb(240, 40, 73)"; // validating the value of text input element for username
		softassert.assertEquals(actualBorder, expectedBorder);
		System.out.println("Border turns to red");

		// Verify whether the error message is displayed under the text input element
		// for email - pass
		String actualerrorMessage = driver.findElement(By.xpath("(//div[@class='fsl fwb fcb'])[1]")).getText();
		String expectederrorMessage = "Wrong credentials";
		softassert.assertEquals(actualerrorMessage, expectederrorMessage);
		System.out.println("Error Message is displayed sucessfully");

		// assertAll method is used to check all the assertion and fail the asset which
		// is mismatching and continue the execution
		softassert.assertAll();
	}
	@Test
	public void testOrangeHRMLogin() throws InterruptedException {
		SoftAssert softassert = new SoftAssert();

		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");

		driver.findElement(By.xpath("(//input[@placeholder='Username'])[1]")).sendKeys("Admin");
		// Wrong password is given to intentionally fail the method
		driver.findElement(By.xpath("(//input[@placeholder='Password'])[1]")).sendKeys("admin1234");
		driver.findElement(By.xpath("(//button[normalize-space()='Login'])[1]")).click();

		Thread.sleep(2000);
		boolean dashboard = driver.findElement(By.xpath("(//h6[normalize-space()='Dashboard'])[1]")).isDisplayed();
		softassert.assertTrue(dashboard);
		softassert.assertAll();
	}
}
