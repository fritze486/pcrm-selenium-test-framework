/**
 * 
 */
package com.csnet.pages.home;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * @author Richard
 *
 */
public class RegisterPage {
	private WebDriver driver;
	
	@FindBy(id = "fname")
	private WebElement txtbxFirstName;
	
	@FindBy(id = "lname")
	private WebElement txtbxLastName;
	
	@FindBy(id = "email")
	private WebElement txtbxEmail;
	
	@FindBy(id = "phone")
	private WebElement txtbxPhoneNumber;
	
	@FindBy(id = "ftpid")
	private WebElement txtbxCompanyID;
	
	@FindBy(id = "username")
	private WebElement txtbxUserName;	
	
	@FindBy(xpath = "//*[@id=\"registerForm\"]/input[7]")
	private WebElement termsYesRadioBtn;
	
	@FindBy(xpath = "//*[@id=\"registerForm\"]/input[8]")
	private WebElement termsNoRadioBtn;
	
	@FindBy(xpath = "//*[@id=\"registerForm\"]/span/a")
	private WebElement termsReadLink;
	
	@FindBy(xpath = "//*[@id=\"registerForm\"]/input[9]")
	private WebElement registerSubmitBtn;
	
	public RegisterPage (WebDriver driver){
	     this.driver=driver;
	
	     //Initialise Elements
	     PageFactory.initElements(driver, this);
	}

	public WebElement getTxtbxFirstName() {
		return txtbxFirstName;
	}

	public void enterTxtbxFirstName(String firstName) {
		this.txtbxFirstName.clear();
		this.txtbxFirstName.sendKeys(firstName);
	}

	public WebElement getTxtbxLastName() {
		return txtbxLastName;
	}

	public void enterTxtbxLastName(String lastName) {
		this.txtbxLastName.clear();
		this.txtbxLastName.sendKeys(lastName);
	}

	public WebElement getTxtbxEmail() {
		return txtbxEmail;
	}

	public void enterTxtbxEmail(String email) {
		this.txtbxEmail.clear();
		this.txtbxEmail.sendKeys(email);
	}

	public WebElement getTxtbxPhoneNumber() {
		return txtbxPhoneNumber;
	}

	public void enterTxtbxPhoneNumber(String phoneNumber) {
		this.txtbxPhoneNumber.clear();
		this.txtbxPhoneNumber.sendKeys(phoneNumber);
	}

	public WebElement getTxtbxCompanyID() {
		return txtbxCompanyID;
	}

	public void enterTxtbxCompanyID(String companyId) {
		this.txtbxCompanyID.clear();
		this.txtbxCompanyID.sendKeys(companyId);
	}

	public WebElement getTxtbxUserName() {
		return txtbxUserName;
	}

	public void enterTxtbxUserName(String userName) {
		this.txtbxUserName.clear();
		this.txtbxUserName.sendKeys(userName);
	}

	public WebElement getTermsYesRadioBtn() {
		return this.termsYesRadioBtn;
	}

	public void setTermsNoRadioBtn() {
		this.termsNoRadioBtn.click();
	}

	public WebElement getTermsReadLink() {
		return termsReadLink;
	}

	public WebElement getRegisterSubmitBtn() {
		return registerSubmitBtn;
	}
	
    public RegisterSuccessPage submit(){
    	registerSubmitBtn.click();
        return new RegisterSuccessPage(driver);
    }
	
    public RegisterFailPage submitFail(){
    	registerSubmitBtn.click();
        return new RegisterFailPage(driver);
    }

	
}
