package com.training.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class FilterCustomerListPOM {
	
	private WebDriver driver;

	public FilterCustomerListPOM(WebDriver driver) {
		this.driver = driver; 
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(id="input-username")
	private WebElement userName; 
	
	@FindBy(id="input-password")
	private WebElement password;
	
	@FindBy(xpath="//*[@type='submit']")
	private WebElement loginBtn; 
	
	public void sendUserName(String userName) {
		this.userName.clear();
		this.userName.sendKeys(userName);
	}
	
	public void sendPassword(String password) {
		this.password.clear(); 
		this.password.sendKeys(password); 
	}
	
	public void clickLoginBtn() {
		this.loginBtn.click(); 
	}
	
	@FindBy(xpath = "//*[@id=\"menu-customer\"]/a")
	private WebElement customerMenu; 
	
	@FindBy(linkText = "Customers")
	private WebElement selectCustomers;
	
	@FindBy(id ="input-name")
	public WebElement customerName;
	
	@FindBy(id ="input-email")
	public WebElement email; 
	
	@FindBy(id ="button-filter")
	private WebElement filterBtn; 
	
	@FindBy(xpath = "//*[@id=\"form-customer\"]/div/table/tbody")
	public WebElement table;
	
	@FindBy(xpath = "//*[@id=\"form-customer\"]/div/table/tbody/tr")
	public WebElement rowtext;
	
	public void clickCustomerMenu() {
		this.customerMenu.click();
	}
	
	public void clickCustomers() {
		this.selectCustomers.click();
	}
	
	public void sendCustomerName(String customerName) {
		this.customerName.clear();
		this.customerName.sendKeys(customerName);
	}
	
	public void sendEmail(String email) {
		this.email.clear(); 
		this.email.sendKeys(email); 
	}
		
	public void filterBtn() {
		this.filterBtn.click(); 
	}
	
	public boolean verifyCustomerDet(String s)
	{
		String s1;
		s1 = this.customerName.getAttribute("value");
		if(s.contains(s1))	
			return true;
			else
			return false;
	}
	
	public boolean verifyEmail(String s)
	{
		String s1;
		s1 = this.email.getAttribute("value");
		if(s.contains(s1))	
			return true;
			else
			return false;
	}

}
