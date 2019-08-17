package com.csnet.java;

import java.util.Properties;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class ChromeDriverManager extends DriverManager{

	/**
	 * @param properties
	 */
	public ChromeDriverManager(Properties properties) {
		this.properties = properties;
	}

	@Override
	protected void createWebDriver() {
		ChromeOptions options = new ChromeOptions();
		String driverPath = "drivers\\chromeDriver\\chromedriver_76.exe";
//		System.setProperty("webdriver.chrome.driver", driverPath);
		System.setProperty("webdriver.chrome.driver", properties.getProperty("chrome.driver.path"));
		this.driver = new ChromeDriver(options);
		
	}

}
