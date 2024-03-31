package org.dataprovider;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Arrays;
import java.util.concurrent.TimeUnit;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import io.github.bonigarcia.wdm.WebDriverManager;

public class ParallelExecutionWithDataProvider {
	
WebDriver driver;
	
	@Test(dataProvider = "ExcelData")
	public void LoginDataFromExcel(String username, String password) throws InterruptedException {
		SoftAssert softassert = new SoftAssert();
		
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		driver.findElement(By.xpath("(//input[@placeholder='Username'])[1]")).sendKeys(username);
		driver.findElement(By.xpath("(//input[@placeholder='Password'])[1]")).sendKeys(password);
		driver.findElement(By.xpath("(//button[normalize-space()='Login'])[1]")).click();
		
		try {
			WebElement dashboard = driver.findElement(By.xpath("(//h6[normalize-space()='Dashboard'])[1]"));
			boolean display = dashboard.isDisplayed();
			softassert.assertTrue(display);
			if(display == true) {
				System.out.println("Login is success");
				
			}
												
		}catch(NoSuchElementException e)
		{
			WebElement errormessage = driver.findElement(By.xpath("(//p[@class='oxd-text oxd-text--p oxd-alert-content-text'])[1]"));
			boolean error = errormessage.isDisplayed();
			softassert.assertTrue(error);
			System.out.println(errormessage.getText());
			
		}
		finally{
		
			softassert.assertAll();
			Thread.sleep(5000);
			driver.close();
		}
	
	}
	
	@DataProvider(parallel = true)
	public String[][] ExcelData() throws IOException {

		// File class is used to locate the excel workbook which is save in a path
		File excelfile = new File("C:\\Users\\AJ-M\\eclipse-workspace\\TestNGProject\\src\\test\\resources\\TestData.xlsx");
		// exists method is used to check whether the file is existing in that path
		System.out.println(excelfile.exists());

		// FileInputStream class is used to read the data from the excel workbook
		FileInputStream file = new FileInputStream(excelfile);

		// XSSFWorkBook class is used to access the workbook
		XSSFWorkbook workbook = new XSSFWorkbook(file);

		// XSSFSheet class is used to access the particular sheet in the workbook with
		// getSheet method
		XSSFSheet sheet = workbook.getSheet("LoginData");

		int rows = sheet.getPhysicalNumberOfRows(); // get total number of rows in the sheet
		int columns = sheet.getRow(0).getLastCellNum(); // get total number of columns or cell from the first row

		System.out.println("Total number of rows : " + rows);
		System.out.println("Total number of columns from first row : " + columns);

		String[][] data = new String[rows-1][columns];  // Data from excel read in the form of array
		for (int i = 0; i < rows-1; i++) {
			for (int j = 0; j < columns; j++) {
				// DataFormatter class will convert any type of data type to string
				DataFormatter df = new DataFormatter();
				data[i][j] = df.formatCellValue(sheet.getRow(i+1).getCell(j));

			}
		}
		
		for (String[] dataArray : data) {
			System.out.println(Arrays.toString(dataArray));
		}
		
		workbook.close(); // close the connect of workbook
		file.close(); // close the connect of file.
		return data;
	}
}
