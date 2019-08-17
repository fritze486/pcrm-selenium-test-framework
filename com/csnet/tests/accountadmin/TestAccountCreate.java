/**
 * 
 */
package com.csnet.tests.accountadmin;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.fail;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;

import com.csnet.java.MainMenu;
import com.csnet.java.MenuLink;
import com.csnet.pages.accountadmin.AccountDetailsPage;
import com.csnet.pages.accountadmin.AccountHelper;

/**
 * @author Richard Hiley
 *
 */
public class TestAccountCreate extends TestAccountSetup {
	
	@AfterClass
	public void cleanUp() {
//		driverManager.quitWebDriver();		
	}
	
	@Test
	public void testAccountCreateRequired() {
		System.out.println("*** testAccountCreateRequired ***");		
		driver.get("http://csnet");
		WebDriverWait wait = new WebDriverWait(driver,3);
		
		//Navigate to Account Admin.
		MainMenu.clickLink(driver, MenuLink.ACCOUNTADMIN);
		
		//Init Account Admin object
		AccountDetailsPage accountDetails = null;
		
		try {
			accountDetails = new AccountDetailsPage(driver);
		} catch (Exception e) {
			fail("Failed to create account Detail object");
		}		
		
		// Click New Account Menu Button
		accountDetails.newAccountBtn.click();
		
		// Init Account Details object and create account.
		AccountHelper.setupAccountRequiredFieds(driver, accountDetails);
		accountDetails.saveAccountBtn.click();
		driver.switchTo().alert().accept();
		
		WebElement element = driver.findElement(By.xpath("//*[@id=\"actAdmActName\"]"));
		System.out.println("element.getText(): " + element.getAttribute("value"));
		
		// Get new account Name and close account
		// wait for edit button to be enabled before clicking close account.
		wait.until(ExpectedConditions.attributeToBe(accountDetails.editAccountBtn, "aria-disabled", "false"));
		String newAccountName = accountDetails.getAccountName();
		accountDetails.closeAccountBtn.click();
		wait.until(ExpectedConditions.attributeToBe(accountDetails.searchForAccountBtn, "aria-disabled", "false"));
		
		
		// Clear Page and Search for new account.
		try {
			accountDetails = new AccountDetailsPage(driver);
		} catch (Exception e) {
			fail("Failed to create account Detail object");
		}
		accountDetails.enterTxtbxAccountName(newAccountName);
		accountDetails.searchForAccountBtn.click();
		
		// Check if 1 row is returned.
		String trXpath = "//*[@id='tblBody']//*[text()='" + newAccountName + "']//parent::tr";
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(trXpath)));		
		List<WebElement> rowsFound = driver.findElements(By.xpath("//*[@id=\"tblBody\"]/tr"));
		assertEquals(rowsFound.size(), 1);
		rowsFound.get(0).click();		
		
		// Wait for Account to be populated and 
		// Test if Edit button is enabled and Account Name is set to expected value.
		wait.until(ExpectedConditions.attributeToBe(accountDetails.editAccountBtn, "aria-disabled", "false"));
		assertEquals(accountDetails.getAccountName(), newAccountName);		
		
	}
	
	@Test
	public void testReadAccount() {
		System.out.println("*** testAccountCreateRequired ***");		
		driver.get("http://csnet");
		
		//Navigate to Account Admin.
		MainMenu.clickLink(driver, MenuLink.ACCOUNTADMIN);
		
		// Click Google from Search list to view Google Account.
		String accountName = "Google";
		String trXpath = "//*[@id='tblBody']//*[text()='" + accountName + "']//parent::tr";
		driver.findElement(By.xpath(trXpath)).click();
		
	}

}
