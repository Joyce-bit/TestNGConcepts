package org.rerun;

import static org.testng.Assert.assertEquals;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;
import io.github.bonigarcia.wdm.WebDriverManager;

public class TestClassForRerun {
	
	WebDriver driver;
	
	@BeforeTest
	public void set()
	{
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("htttps://www.google.com");
	}
	
	@AfterTest
	public void tearDown() throws InterruptedException {
		Thread.sleep(2000);
		driver.quit();
	}
	
	@Test(retryAnalyzer = RerunnerClass.class)
	public void testGoogle() {
		String title = driver.getTitle();
		assertEquals(title, "google");
		
	}
}
