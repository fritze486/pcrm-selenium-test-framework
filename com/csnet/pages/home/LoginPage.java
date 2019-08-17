/**
 * 
 */
package com.csnet.pages.home;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * @author Richard
 *
 */
public class LoginPage {
	private WebDriver driver;
	
	@FindBy(xpath = "//*[@id=\"search\"]/tbody/tr[1]/td/form/input[1]")
	private WebElement userNameInput;
	
	@FindBy(xpath = "//*[@id=\"search\"]/tbody/tr[1]/td/form/input[2]")
	private WebElement passswordInput;
	
	@FindBy(name = "buttonLogin")
	private WebElement loginButton;
	
	@FindBy(name = "logOutBtn")
	private WebElement logOutButton;	
	
	public LoginPage (WebDriver driver){
	     this.driver=driver;
	
	     //Initialise Elements
	     PageFactory.initElements(driver, this);
	}
	
	public LoginPage(WebDriver driver, String userName, String password){
		this.driver = driver;
	    PageFactory.initElements(driver, this);
	    driver.get("http://csnet");
	    this.setUserName(userName);
	    this.setPassword(password);
	    this.clickLoginButton();
	}	
	
	public void setUserName(String userName) {
		userNameInput.clear();
		userNameInput.sendKeys(userName);
	}
	
	public void setPassword(String password) {
		passswordInput.clear();
		passswordInput.sendKeys(password);
	}
	
	public WebElement getLoginButton() {
		return loginButton;
	}
	
	public WebElement getLogOutButton() {
		return logOutButton;
	}

	public void clickLoginButton() {
		loginButton.click();
	}

	public void clickLogOutButton() {
		logOutButton.click();
	}
	
	public boolean isLoggedIn() {
		boolean result = false;
		if (logOutButton.isDisplayed()) {result = true;}
		return result;
	}
	
	public boolean isLoggedOut() {
		boolean result = false;
		if (loginButton.isDisplayed()) {result = true;}
		return result;
	}

}
