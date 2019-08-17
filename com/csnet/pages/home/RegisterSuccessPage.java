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
public class RegisterSuccessPage {
	private WebDriver driver;
	
	@FindBy(xpath = "//*[@id=\"divBody\"]/h2")
	private WebElement resultHeader;
	
	public RegisterSuccessPage (WebDriver driver){
	     this.driver=driver;
	
	     //Initialise Elements
	     PageFactory.initElements(driver, this);
	}
	
	public String getResullMessage() {
		return resultHeader.getText();
	}

}
