/**
 * 
 */
package com.csnet.tests.accountadmin;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;

import com.csnet.java.MainMenu;
import com.csnet.java.MenuLink;
import com.csnet.pages.accountadmin.AccountConstants;
import com.csnet.pages.accountadmin.AccountPage;

/**
 * @author Richard
 *
 */
public class TestAccount extends TestAccountSetup {
	
	@AfterClass
	public void cleanUp() {
		driverManager.quitWebDriver();		
	}
		
	@Test
	public void testAccountNavigation() throws IOException {
		System.out.println("*** testAccountNavigation ***");
		account = new AccountPage(driver);
		
		driver.get("http://csnet");
		MainMenu.clickLink(driver, MenuLink.ACCOUNTADMIN);
		
		// Wait until Search tab is active.
		WebDriverWait wait = new WebDriverWait(driver,3);
		wait.until(ExpectedConditions.attributeContains(account.getElementSearchTab(), "class", "ui-state-active"));
		assertTrue(account.isTabActive("Search"));

		// Go to account Google details
		account.gotoAccountByName(AccountConstants.DEFAULT_ACCNT_NAME);
		wait.until(ExpectedConditions.attributeContains(account.getElementDetailsTab(), "class", "ui-state-active"));
		assertEquals(account.getAccountName(), AccountConstants.DEFAULT_ACCNT_NAME);
		assertTrue(account.isTabActive("Details"));
	}
	
	@Test
	public void testSandbox() {
		System.out.println("*** testSandbox ***");
		driver.get("http://csnet");
		MainMenu.clickLink(driver, MenuLink.ACCOUNTADMIN);
		WebDriverWait wait = new WebDriverWait(driver,3);
		wait.until(ExpectedConditions.attributeContains(account.getElementSearchTab(), "class", "ui-state-active"));
		String tabName = "Details";
		String xpath = "//ul[contains(@class, 'ui-tabs-nav')]/li/a[contains(text(),'Details')]//parent::li";
		List<WebElement> elements = driver.findElements(By.xpath(xpath));
		System.out.println("Size: " + elements.size());
		System.out.println("Class: " + elements.get(0).getAttribute("class"));
		System.out.println(account.isTabActive(tabName));
		account.gotoAccountByName("Google");
		wait.until(ExpectedConditions.attributeContains(account.getElementDetailsTab(), "class", "ui-state-active"));
		System.out.println(account.isTabActive(tabName));
	}

}
