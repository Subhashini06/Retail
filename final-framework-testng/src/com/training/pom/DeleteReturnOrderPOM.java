package com.training.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DeleteReturnOrderPOM {
	
private WebDriver driver;

public DeleteReturnOrderPOM(WebDriver driver) {
	this.driver = driver;
	PageFactory.initElements(driver, this);
}

@FindBy(id = "input-username")
private WebElement userName;

@FindBy(id = "input-password")
private WebElement password;

@FindBy(xpath = "//*[@type='submit']")
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

@FindBy(xpath = "//tbody/tr[1]/td[1]")
private WebElement tablerow;



@FindBy(xpath = "//button/i")
private WebElement deleteBtn;

@FindBy(xpath = "//DIV[@class='alert alert-success']")
public WebElement alertMsg;

public void clickSaleMenu() {
	this.salemenu.click();
}

public void clickReturns() 
{
	this.selectReturns.click();
}

	
public void tablerowcheckbox()
{
	this.tablerow.click();
}

public void deleteBtn()
{
	this.deleteBtn.click();
}


public boolean verifyAlertMsg(String s)
{
	String s1;
	s1 = "Success: You have modified returns!";
	if(s.contains(s1))	
		return true;
		else
		return false;
}

}
