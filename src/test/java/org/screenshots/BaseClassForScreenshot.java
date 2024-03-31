package org.screenshots;

import java.io.File;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.concurrent.TimeUnit;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;
import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClassForScreenshot {
	
	public static WebDriver driver;
	public static String screenshotsubfolder;

	@BeforeTest
	public void set() {

		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().window().maximize();
	}
	
	@AfterTest
	public void tearDown() throws InterruptedException {

		Thread.sleep(3000);
		driver.close();
	}
	
	public void captureScreenShot(String fileName) throws IOException {
		
		if(screenshotsubfolder == null) {
			LocalDateTime datetime = LocalDateTime.now();  
	        DateTimeFormatter dataformatter = DateTimeFormatter.ofPattern("ddMMyyyyHHmmss");  
	        screenshotsubfolder = datetime.format(dataformatter); 
		}

		TakesScreenshot takescreenshot = (TakesScreenshot) driver;
		File SourceFile = takescreenshot.getScreenshotAs(OutputType.FILE);
		File desFile = new File("./ScreenShots/"+ screenshotsubfolder+"/"+fileName);
		try {
			FileUtils.copyFile(SourceFile, desFile);
		} catch (IOException e) {
			e.printStackTrace();
		}
		System.out.println("Screenshot saved successfully");
	}
}
