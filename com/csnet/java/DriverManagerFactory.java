package com.csnet.java;

import java.util.Properties;

import com.csnet.resources.DriverType;

public class DriverManagerFactory {

	public static DriverManager getDriverManager
	(DriverType type, Properties properties) {
		DriverManager driverManager;
		switch(type) {
		case CHROME:
			driverManager = new ChromeDriverManager(properties);
			break;
		case FIREFOX:
			driverManager = new FirefoxDriverManager();
			break;
		default:
			driverManager = new IEDriverManager();
			break;
		}
		
		return driverManager;
	}
}
