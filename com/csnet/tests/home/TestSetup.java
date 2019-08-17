/**
 * 
 */
package com.csnet.tests.home;

import java.util.Properties;

import org.openqa.selenium.WebDriver;

import com.csnet.java.ConfigProperties;
import com.csnet.java.DriverManager;
import com.csnet.java.DriverManagerFactory;
import com.csnet.resources.DriverType;

/**
 * @author Richard
 *
 */
public class TestSetup {
	protected static Properties properties= ConfigProperties.getProperties();
	protected static DriverManager driverManager= DriverManagerFactory.getDriverManager(DriverType.CHROME, properties);
	protected static WebDriver driver = driverManager.getWebDriver();
	
	public static void gotoHomePage() {
		driver.get("http://csnet");
	}
	
	public static void quitDriver() {
		driverManager.quitWebDriver();
	}
}
