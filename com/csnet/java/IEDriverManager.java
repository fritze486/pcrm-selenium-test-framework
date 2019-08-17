package com.csnet.java;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.ie.InternetExplorerOptions;

public class IEDriverManager extends DriverManager{

	@Override
	protected void createWebDriver() {
		InternetExplorerOptions options = new InternetExplorerOptions();
		
		
		this.driver = new InternetExplorerDriver();
	}

}
