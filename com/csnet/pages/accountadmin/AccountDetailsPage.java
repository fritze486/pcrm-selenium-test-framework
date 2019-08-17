/**
 * 
 */
package com.csnet.pages.accountadmin;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

/**
 * @author Richard
 *
 */
public class AccountDetailsPage extends AccountPage {

	/**
	 * @param driver
	 */
	

	// Find Form Fields Elements
		@FindBy(id = "actAdmMaintStatus")
		private WebElement txtbxActAdmMaintStatus;

		@FindBy(id = "actAdmDeployStatus")
		private WebElement selectActAdmDeployStatus;

		@FindBy(id = "actAdmMaintExpDate")
		private WebElement txtbxActAdmMaintExpDate;

		@FindBy(id = "actAdmContractDate")
		private WebElement txtbxActAdmContractDate;

		@FindBy(id = "actAdmFtpLogin")
		private WebElement txtbxActAdmFtpLogin;

		@FindBy(id = "actAdmFtpPasswd")
		private WebElement txtbxActAdmFtpPasswd;

		@FindBy(id = "actAdmSupportLevel")
		private WebElement selectActAdmSupportLevel;

		@FindBy(id = "actAdmHours")
		private WebElement txtbxActAdmHours;
		
		
	public AccountDetailsPage(WebDriver driver) {
		super(driver);
		
	     //Init Elements
	     PageFactory.initElements(driver, this);
	}

	public void selectDeployStatus(String status) {
		Select select = new Select(this.selectActAdmDeployStatus);
		select.selectByValue(status);
	}
	
	public void enterTxtbxMaintExpDate(String date) {
		this.txtbxActAdmMaintExpDate.clear();
		this.txtbxActAdmMaintExpDate.sendKeys(date);
	}
	
	public void enterTxtbxContractDate(String date) {
		this.txtbxActAdmContractDate.clear();
		this.txtbxActAdmContractDate.sendKeys(date);
	}
	
	public void enterTxtbxFtpLogin(String date) {
		this.txtbxActAdmFtpLogin.clear();
		this.txtbxActAdmFtpLogin.sendKeys(date);
	}
	
	public void enterTxtbxFtpPasswd(String date) {
		this.txtbxActAdmFtpPasswd.clear();
		this.txtbxActAdmFtpPasswd.sendKeys(date);
	}

	public void selectSupportLevel(String supportLevel) {
		Select select = new Select(this.selectActAdmSupportLevel);
		select.selectByValue(supportLevel);
	}
	
	public void enterTxtbxCoverageHours(String hours) {
		this.txtbxActAdmHours.clear();
		this.txtbxActAdmHours.sendKeys(hours);
	}

}
