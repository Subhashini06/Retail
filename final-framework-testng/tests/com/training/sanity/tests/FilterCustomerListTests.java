package com.training.sanity.tests;

import org.testng.annotations.Test;

import com.training.generics.ScreenShot;
import com.training.pom.FilterCustomerListPOM;
import com.training.pom.FilterOrderDetails;
import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;

import org.testng.annotations.BeforeClass;

import static org.testng.Assert.assertEquals;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.List;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterTest;

public class FilterCustomerListTests {
	
	private WebDriver driver;
	private String baseUrl;
	private FilterCustomerListPOM filterCustomerListPOM;
	private static Properties properties;
	private ScreenShot screenShot;
  

  
  @BeforeClass
	public void setUpBeforeClass() throws IOException {
		properties = new Properties();
		FileInputStream inStream = new FileInputStream("./resources/others.properties");
		properties.load(inStream);
		driver = DriverFactory.getDriver(DriverNames.CHROME);
		filterCustomerListPOM = new FilterCustomerListPOM(driver);
		baseUrl = properties.getProperty("baseURL");
		screenShot = new ScreenShot(driver);
		// open the browser
		driver.get(baseUrl);
	}
  
  @Test (priority = 1)
	public void validLoginTest() {
	  filterCustomerListPOM.sendUserName("admin");
	  filterCustomerListPOM.sendPassword("admin@123");
	  filterCustomerListPOM.clickLoginBtn(); 
		screenShot.captureScreenShot("First");
	}

	@Test (priority = 2)
	public void validOrderDetails() throws InterruptedException {
		Thread.sleep(2000);
		filterCustomerListPOM.clickCustomerMenu();
		filterCustomerListPOM.clickCustomers();
		filterCustomerListPOM.sendCustomerName("subhashini rangaraju");
		filterCustomerListPOM.filterBtn();
		screenShot.captureScreenShot("Second");
		List<WebElement> rows = filterCustomerListPOM.table.findElements(By.tagName("tr"));
		for(WebElement tdata: rows)
		{
			String rowdata = tdata.getText();
			System.out.println("Fetched from customer name" +rowdata);
			boolean expected1 = true;
			boolean actual1 = filterCustomerListPOM.verifyCustomerDet(rowdata);
			assertEquals(actual1, expected1);
		}
		
		//Fetching the customer list by Email
		filterCustomerListPOM.customerName.clear();
		filterCustomerListPOM.sendEmail("a@yahoo.com");
		filterCustomerListPOM.filterBtn(); 
		screenShot.captureScreenShot("Third");
		String resEmail = filterCustomerListPOM.rowtext.getText();
		System.out.println("Fetched from Email" +resEmail);
		boolean expected1 = true;
		boolean actual1 = filterCustomerListPOM.verifyEmail(resEmail);
		assertEquals(actual1, expected1);
		
	}
  

  @AfterTest
	public void tearDown() throws Exception {
		Thread.sleep(1000);
		driver.quit();
	}

}
