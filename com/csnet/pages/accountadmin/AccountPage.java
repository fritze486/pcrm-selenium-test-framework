/**
 * 
 */
package com.csnet.pages.accountadmin;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

/**
 * @author Richard
 *
 */
public class AccountPage {
	private WebDriver driver;

// Find Menu Buttons Elements
	@FindBy(id = "addAcnt")
	public WebElement newAccountBtn;
	
	@FindBy(id = "modAcnt")
	public WebElement editAccountBtn;
	
	@FindBy(id = "saveAcnt")
	public WebElement saveAccountBtn;
	
	@FindBy(id = "searchAcnt")
	public WebElement searchForAccountBtn;
	
	@FindBy(id = "clsAcnt")
	public WebElement closeAccountBtn;
	
	@FindBy(id = "clearFltr")
	public WebElement clearAccountFilterBtn;	

// Find Form Fields Elements
	@FindBy(id = "actAdmActName")
	private WebElement txtbxAccountName;
	
	@FindBy(id = "actAdmInstlSite")
	private WebElement txtbxInstallSite;
	
	@FindBy(id = "actAdmActInstId")
	private WebElement txtbxInstId;
	
	@FindBy(id = "actAdmCoCode")
	private WebElement txtbxCompanyCode;
	
	@FindBy(id = "actAdmActStatus")
	private WebElement selectStatus;
	
	@FindBy(id = "actAdmStatusDate")
	private WebElement txtbxStatusDate;
	
	// Find Tab elements	
	@FindBy(xpath = "//*[@id=\"tabs\"]/ul/li[1]")
	private WebElement detailsTab;

	@FindBy(xpath = "//*[@id=\"tabs\"]/ul/li[2]")
	private WebElement productsTab;

	@FindBy(xpath = "//*[@id=\"tabs\"]/ul/li[3]")
	private WebElement environmentsTab;

	@FindBy(xpath = "//*[@id=\"tabs\"]/ul/li[4]")
	private WebElement licensesTab;

	@FindBy(xpath = "//*[@id=\"tabs\"]/ul/li[5]")
	private WebElement downloadsTab;

	@FindBy(xpath = "//*[@id=\"tabs\"]/ul/li[6]")
	private WebElement searchTab;

	@FindBy(xpath = "//*[@id=\"tabs\"]/ul/li[7]")
	private WebElement reportsTab;

	public AccountPage(WebDriver driver) {
		this.driver = driver;
		
	     //Initialise Elements
	     PageFactory.initElements(driver, this);
	}	

	// Click Tab by Name
	public void clickTabByText(String tabText) {		
		switch  (tabText) {
			case "Details": 
				detailsTab.click();
				break;
			case "Products": 
				productsTab.click();
				break;
			case "Environments": 
				environmentsTab.click();
				break;
			case "Licenses": 
				licensesTab.click();
				break;
			case "Downloads": 
				downloadsTab.click();
				break;
			case "Search": 
				searchTab.click();
				break;
			case "Reports": 
				reportsTab.click();
				break;
			default: 
				break;
		}		
	}
	
	public void enterTxtbxAccountName(String name) {
		this.txtbxAccountName.clear();
		this.txtbxAccountName.sendKeys(name);
	}

	public String getAccountName() {
		return txtbxAccountName.getAttribute("value");
	}
	
	public void enterTxtbxInstallSite(String name) {
		this.txtbxInstallSite.clear();
		this.txtbxInstallSite.sendKeys(name);
	}

	public String getInstallSiteTextBox() {
		return txtbxInstallSite.getText();
	}
	
	public void enterTxtbxCompanyCode(String name) {
		this.txtbxCompanyCode.clear();
		this.txtbxCompanyCode.sendKeys(name);
	}

	public String getCompanyCodeTextBox() {
		return txtbxCompanyCode.getText();
	}

	public void selectStatus(String status) {
		Select select = new Select(this.selectStatus);
		select.selectByValue(status);
	}

	public String getStatusSelected() {
		Select select = new Select(this.selectStatus);
		return select.getFirstSelectedOption().getAttribute("value");
	}
	
	public void enterTxtbxStatusDate(String name) {
		this.txtbxStatusDate.clear();
		this.txtbxStatusDate.sendKeys(name);
	}

	public String getStatusDateTextBox() {
		return txtbxStatusDate.getText();
	}
	
	public WebElement getElementDetailsTab() {
		return detailsTab;
	}
	
	public WebElement getElementSearchTab() {
		return searchTab;
	}
	
	public void gotoAccountByName(String accountName) {
		WebElement accountLink; 
		String trXpath = "//*[@id='tblBody']//*[text()='" + accountName + "']//parent::tr";		
		try {
			accountLink = driver.findElement(By.xpath(trXpath));
			accountLink.click();
		} catch (Exception e) {
			// TODO Auto-generated catch block
//			e.printStackTrace();
			System.out.println("[ERROR] [AccountPage.gotoAccountByName] [Account with name " + accountName + " was not found.]");
		}
	}
	
	public boolean isTabActive(String tabName) {
		boolean result = false;
		String tabXpath = "//ul[contains(@class, 'ui-tabs-nav')]/li/a[contains(text(),'" + tabName + "')]//parent::li";
		WebElement tabLi = driver.findElement(By.xpath(tabXpath));		
		if (tabLi.getAttribute("class").contains("ui-state-active")) {result = true;}
		
		return result;
	}
	
}
