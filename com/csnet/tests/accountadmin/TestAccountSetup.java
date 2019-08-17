/**
 * 
 */
package com.csnet.tests.accountadmin;

import java.util.Properties;

import org.openqa.selenium.WebDriver;

import com.csnet.java.ConfigProperties;
import com.csnet.java.DriverManager;
import com.csnet.java.DriverManagerFactory;
import com.csnet.pages.accountadmin.AccountPage;
import com.csnet.pages.home.LoginPage;
import com.csnet.resources.DriverType;

/**
 * @author Richard
 *
 */
public class TestAccountSetup {
	protected static Properties properties= ConfigProperties.getProperties();
	protected static DriverManager driverManager= DriverManagerFactory.getDriverManager(DriverType.CHROME, properties);
	protected static WebDriver driver = driverManager.getWebDriver();
	protected static LoginPage login = new LoginPage(driver, 
			properties.getProperty("com.csnet.username"),
			properties.getProperty("com.csnet.password"));	
	protected static AccountPage account = new AccountPage(driver);
	
	public static void gotoHomePage() {
		driver.get("http://csnet");
	}
	
	public static void quitDriver() {
		driverManager.quitWebDriver();
	}
}
