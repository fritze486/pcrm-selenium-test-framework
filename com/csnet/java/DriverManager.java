package com.csnet.java;

import java.util.Properties;

import org.openqa.selenium.WebDriver;

public abstract class DriverManager {
	protected WebDriver driver;
	protected Properties properties;
	protected abstract void createWebDriver();
	
	public void quitWebDriver() {
		if(null!=driver) {
			driver.quit();
			driver = null;
		}
	}
	public WebDriver getWebDriver() {
		if (null==driver) {
			createWebDriver();
		}
		return driver;
	}

//	/**
//	 * @param properties
//	 */
//	protected void createWebDriver(Properties properties) {
//		// TODO Auto-generated method stub
//		
//	}

}
