package org.parameters;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.*;
import org.testng.asserts.SoftAssert;
import io.github.bonigarcia.wdm.WebDriverManager;


public class SuiteLevelParameter {
	
	WebDriver driver;
	SoftAssert softassert = new SoftAssert();
  @Parameters("url")
  @Test
  public void launchApp(String url) {
		driver.get(url);
	}
  
  @Test
	public void verifyLogin() {
		
		boolean login = driver.findElement(By.xpath("(//h5[normalize-space()='Login'])[1]")).isDisplayed();
		softassert.assertTrue(login);  // assert validation
		System.out.println(login);
		softassert.assertAll();
	}
  @Parameters({"username", "password"})
  @Test
  public void loginApp(String username, String password) {
		
		driver.findElement(By.xpath("(//input[@placeholder='Username'])[1]")).sendKeys(username);
		driver.findElement(By.xpath("(//input[@placeholder='Password'])[1]")).sendKeys(password);
		driver.findElement(By.xpath("(//button[normalize-space()='Login'])[1]")).click();
	}
  
  @Test
	public void MyInfo() {
		driver.findElement(By.xpath("(//span[normalize-space()='My Info'])[1]")).click();
		
	}
  
  @Test
	public void verifyMyInfo() throws InterruptedException {
		 boolean verify = driver.findElement(By.xpath("(//div[@class='orangehrm-custom-fields'])[1]")).isDisplayed();
		 softassert.assertTrue(verify); // assert validation
		 System.out.println(verify);
		 softassert.assertAll();
  }
  
  @Parameters("browsername")  // browsername is a parameter name from xml file
  @BeforeTest
  public void openBrowser(String browsername) {
	  switch(browsername.toLowerCase()) {
	  case "chrome":
		  WebDriverManager.chromedriver().setup();
		  driver = new ChromeDriver();
		  break;
	  case "edge":
		  WebDriverManager.edgedriver().setup();
		  driver = new EdgeDriver();
		  break;
	  case "firefox":
		  WebDriverManager.firefoxdriver().setup();
		  driver = new FirefoxDriver();
		  break;
	  default:
		  System.out.println("Browser name is invalid");
		  break;
	  }
	  
	  	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().window().maximize();
  }
  
  @Parameters("sleeptime")
  @AfterTest
  public void tearDown(long sleeptime) throws InterruptedException {
	Thread.sleep(sleeptime);
	driver.quit();
  }
}
