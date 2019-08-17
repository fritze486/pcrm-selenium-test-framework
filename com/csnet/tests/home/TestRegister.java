/**
 * 
 */
package com.csnet.tests.home;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;

import com.csnet.java.MainMenu;
import com.csnet.java.MenuLink;
import com.csnet.pages.home.LoginPage;
import com.csnet.pages.home.RegisterConstants;
import com.csnet.pages.home.RegisterFailPage;
import com.csnet.pages.home.RegisterHelper;
import com.csnet.pages.home.RegisterPage;
import com.csnet.pages.home.RegisterSuccessPage;

/**
 * @author Richard Hiley
 *
 */
public class TestRegister extends TestSetup {
	
	@AfterClass
	public void cleanUp() {
//		quitDriver();	
	}
	
	@Test
	public void testRegisterAllFieldsBlank() {
		driver.get("http://csnet");
		MainMenu.clickLink(driver, MenuLink.REGISTER);
		RegisterPage registerPage = new RegisterPage(driver);
		RegisterFailPage registerFail = registerPage.submitFail();
		assertEquals(registerFail.getResult(), RegisterConstants.REG_FAIL_HEADER);
		assertEquals(registerFail.getResultMsg(), RegisterConstants.REG_FAIL_MSG_TERMS_OF_USER);
		System.out.println("errMsg: " + registerFail.getResultMsg());
		
	}
	
	@Test
	public void testRegisterUserFailInvalidCoID() {
		String failedPageUrl = "register-failed.php";
		driver.get("http://csnet");
		MainMenu.clickLink(driver, MenuLink.REGISTER);
		
		// Fill form fields and click register.
		RegisterPage registerPage = new RegisterPage(driver);		
		RegisterHelper.setupRegistration(registerPage, false);
		registerPage.getRegisterSubmitBtn().click();
		
		// Test to confirm directed to Failed Registration page.
		String currentUrl = driver.getCurrentUrl();
		System.out.println("currentUrl: " + currentUrl);
		assertTrue(currentUrl.contains(failedPageUrl));
	}
	
	@Test
	public void testRegisterUserFailDupUserName() {
		System.out.println("[INFO] [testRegisterUser] [Test Entered]");
		String expectedErrMsg = "Registration Successful!";
		// Navigate to Registration page.
		driver.get("http://csnet");
		MainMenu.clickLink(driver, MenuLink.REGISTER);
		
		// Fill in form fields and click register
		RegisterPage registerPage = new RegisterPage(driver);
		RegisterHelper.setupRegistration(registerPage, true);
		String userName = registerPage.getTxtbxUserName().getAttribute("value");
		RegisterSuccessPage registerSuccess = registerPage.submit();
		
		// Test if Registration succeeded as expected.
		String actualErrMsg = registerSuccess.getResullMessage();
		assertEquals(actualErrMsg, expectedErrMsg);
		System.out.println("[INFO] [testRegisterUser] [User Created as " + userName + "]");
		
		// Register User again.
		MainMenu.clickLink(driver, MenuLink.REGISTER);
		RegisterHelper.setupRegistration(registerPage, userName, true);
		RegisterFailPage registerFail = registerPage.submitFail();
		assertEquals(registerFail.getResult(), RegisterConstants.REG_FAIL_HEADER);
		assertEquals(registerFail.getResultMsg(), RegisterConstants.REG_FAIL_MSG_DUP_USERNAME);
		
	}
	
	@Test
	public void testRegisterUser() {
		System.out.println("[INFO] [testRegisterUser] [Test Entered]");
		String expectedErrMsg = "Registration Successful!";
		// Navigate to Registration page.
		driver.get("http://csnet");
		MainMenu.clickLink(driver, MenuLink.REGISTER);
		
		// Fill in form fields and click register
		RegisterPage registerPage = new RegisterPage(driver);
		RegisterHelper.setupRegistration(registerPage, true);
		String userName = registerPage.getTxtbxUserName().getAttribute("value");
		
		System.out.println("userName created: " + userName);
		RegisterSuccessPage registerSuccess = registerPage.submit();
		
		// Test if Registration succeeded as expected.
		String actualErrMsg = registerSuccess.getResullMessage();
		assertEquals(actualErrMsg, expectedErrMsg);
		System.out.println("[INFO] [testRegisterUser] [User Created]");
		
		// Test if you are able to log in as the new user
		LoginPage login = new LoginPage(driver, userName, userName);
		assertTrue(login.isLoggedIn());
		System.out.println("[INFO] [testRegisterUser] [User Logged In]");
		
		// Test that log out was successful.
		login.clickLogOutButton();
		assertTrue(login.isLoggedOut());
		System.out.println("[INFO] [testRegisterUser] [User Logged Out]");
	}

}

