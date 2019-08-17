package com.csnet.tests.home;

import static org.testng.Assert.assertTrue;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;

import com.csnet.java.MainMenu;
import com.csnet.java.MenuLink;
import com.csnet.pages.home.LoginPage;


public class TestLogin extends TestSetup {
	
	@AfterClass
	public void cleanUp() {
		quitDriver();
	}
		
	@Test
	public void testLogin() throws IOException {
		driver.get("http://csnet");
		
		LoginPage login = new LoginPage(driver);
		login.setUserName(properties.getProperty("com.csnet.username"));
		login.setPassword(properties.getProperty("com.csnet.password"));
		login.clickLoginButton();		
		
		if (login.getLogOutButton().isDisplayed()) {
			assertTrue(true);
		}else {
			assertTrue(false);
		}
	}

	@Test
	public void testLogOut() throws IOException {
		driver.get("http://csnet");
		
		// Login.		
		LoginPage login = new LoginPage(driver);
		login.setUserName(properties.getProperty("com.csnet.username"));
		login.setPassword(properties.getProperty("com.csnet.password"));
		login.clickLoginButton();			
		
		// Confirm Login.
		if (login.getLogOutButton().isDisplayed()) {
			assertTrue(true);
		}else {
			assertTrue(false);
		}
		
		//Click Logout Button
		login.clickLogOutButton();
		
		// Confirm Logged out
		if (login.getLoginButton().isDisplayed()) {
			assertTrue(true);
		}else {
			assertTrue(false);
		}
	}
	
	@Test
	public void testMenu() {
		String expectedTitle = "TSNet - Account Admin";
		String expectedHeader = "Account Administration";
				
		MainMenu.clickLink(driver, MenuLink.ACCOUNTADMIN);

		WebElement bodyHeader = driver.findElement(By.xpath("/html/body/div[1]/div[2]/table/tbody/tr/td[3]/div/h2"));
		
		Assert.assertEquals(expectedTitle, driver.getTitle());
		Assert.assertEquals(expectedHeader, bodyHeader.getText());
	}

}
