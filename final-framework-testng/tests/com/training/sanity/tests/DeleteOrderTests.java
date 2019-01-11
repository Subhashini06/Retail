package com.training.sanity.tests;

import org.testng.annotations.Test;

import com.training.generics.ScreenShot;
import com.training.pom.DeleteOrderPOM;
import com.training.pom.FilterOrderDetails;
import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;

import org.testng.annotations.BeforeClass;

import static org.testng.Assert.assertEquals;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;

public class DeleteOrderTests {
	
	private WebDriver driver;
	private String baseUrl;
	private DeleteOrderPOM deleteOrderPOM;
	private static Properties properties;
	private ScreenShot screenShot;
	
 
  
  @BeforeClass
	public void setUpBeforeClass() throws IOException {
		properties = new Properties();
		FileInputStream inStream = new FileInputStream("./resources/others.properties");
		properties.load(inStream);
		driver = DriverFactory.getDriver(DriverNames.CHROME);
		deleteOrderPOM = new DeleteOrderPOM(driver);
		baseUrl = properties.getProperty("baseURL");
		screenShot = new ScreenShot(driver);
		// open the browser
		driver.get(baseUrl);
	}
  
  @Test (priority = 1)
	public void validLoginTest() {
	  	deleteOrderPOM.sendUserName("admin");
	  	deleteOrderPOM.sendPassword("admin@123");
	  	deleteOrderPOM.clickLoginBtn(); 
		screenShot.captureScreenShot("First");
	}
  
  @Test (priority = 2)
  public void validDeleteOrder() throws InterruptedException {
	  	Thread.sleep(2000);
	  	deleteOrderPOM.clickSaleMenu();
	  	deleteOrderPOM.clickOrdersItem();
	  	screenShot.captureScreenShot("Second");
		deleteOrderPOM.tablerowcheckbox();
		Thread.sleep(1000);
		deleteOrderPOM.deleteBtn();
		Alert alert = driver.switchTo().alert();
		alert.accept();
		String res = deleteOrderPOM.alertMsg.getText();
		boolean expected = true;
		boolean actual = deleteOrderPOM.verifyAlertMsg(res);
		assertEquals(actual, expected);
  }

  @AfterTest
	public void tearDown() throws Exception {
		Thread.sleep(1000);
		driver.quit();
	}

}
