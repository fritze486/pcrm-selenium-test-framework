package com.csnet.java;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class MainMenu {
	
	public static void clickLink(WebDriver driver, MenuLink link) {
		
		if (link.toString() == "LOGINHELP") {
			driver.findElement(By.id("linkLoginHelp")).click();
		}else {
			driver.findElement(
				By.xpath("//td[@class='menu'][contains(text(), '" + link.linkText + "')]")).click();
		}
	}

}
