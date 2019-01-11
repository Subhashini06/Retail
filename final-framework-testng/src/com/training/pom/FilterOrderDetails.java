package com.training.pom;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class FilterOrderDetails 
{

private WebDriver driver; 
	
	public FilterOrderDetails(WebDriver driver) {
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
	
	
	@FindBy(xpath = "//*[@id=\"menu-sale\"]/a")
	public WebElement salemenu; 
	
	@FindBy(linkText = "Orders")
	private WebElement selectOrders;
	
	@FindBy(id ="input-order-id")
	public WebElement orderID;
	
	@FindBy(id ="input-customer")
	public WebElement customerName; 
	
	@FindBy(id ="button-filter")
	private WebElement filterBtn; 
	
	@FindBy(xpath = "//*[@id=\"form-order\"]/div/table/tbody")
	public WebElement table;
	
	@FindBy(xpath = "//*[@id=\"form-order\"]/div/table/tbody/tr")
	public WebElement rowtext;
	
	public void clickSaleMenu() {
		this.salemenu.click();
	}
	
	public void clickOrdersItem() {
		this.selectOrders.click();
	}
	
	public void sendOrderID(String orderID) {
		this.orderID.clear();
		this.orderID.sendKeys(orderID);
	}
	
	public void sendCustomerName(String customerName) {
		this.customerName.clear(); 
		this.customerName.sendKeys(customerName); 
	}
		
	public void filterBtn() {
		this.filterBtn.click(); 
	}
	
		
	public boolean verifyOrderID(String s)
	{
		String s1;
		s1 = this.orderID.getAttribute("value");
		if(s.contains(s1))	
			return true;
			else
			return false;
	}
	
	public boolean verifyCustomer(String s)
	{
		String s1;
		s1 = this.customerName.getAttribute("value");
		if(s.contains(s1))	
			return true;
			else
			return false;
	}
	
	
	
}
