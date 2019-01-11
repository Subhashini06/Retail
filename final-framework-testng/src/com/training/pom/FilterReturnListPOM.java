package com.training.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class FilterReturnListPOM {
	
private WebDriver driver; 
	
	public FilterReturnListPOM(WebDriver driver) {
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
	
	@FindBy(linkText = "Returns")
	private WebElement selectReturns;
	
	@FindBy(id ="input-return-id")
	public WebElement returnID;
	
	@FindBy(id ="input-customer")
	public WebElement retcustomerName; 
	
	@FindBy(id ="button-filter")
	private WebElement filterBtn; 
	
	@FindBy(xpath = "//*[@id=\"form-return\"]/div/table/tbody")
	public WebElement table;
	
	@FindBy(xpath = "//*[@id=\"form-return\"]/div/table/tbody/tr")
	public WebElement rowtext;
	
	public void clickSaleMenu() {
		this.salemenu.click();
	}
	
	public void clickReturns() {
		this.selectReturns.click();
	}
	
	public void sendReturnID(String returnID) {
		this.returnID.clear();
		this.returnID.sendKeys(returnID);
	}
	
	public void sendretCustomerName(String retcustomerName) {
		this.retcustomerName.clear(); 
		this.retcustomerName.sendKeys(retcustomerName); 
	}
		
	public void filterBtn() {
		this.filterBtn.click(); 
	}
	
	public boolean verifyreturnID(String s)
	{
		String s1;
		s1 = this.returnID.getAttribute("value");
		if(s.contains(s1))	
			return true;
			else
			return false;
	}
	
	public boolean verifyCustomer(String s)
	{
		String s1;
		s1 = this.retcustomerName.getAttribute("value");
		if(s.contains(s1))	
			return true;
			else
			return false;
	}

}
