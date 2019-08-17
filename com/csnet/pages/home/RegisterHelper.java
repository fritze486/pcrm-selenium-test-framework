/**
 * 
 */
package com.csnet.pages.home;

import com.csnet.resources.Utilities;

/**
 * @author Richard
 *
 */
public class RegisterHelper {
	
	public static void setupRegistration(RegisterPage registerPage, boolean registrationValid) {
		String lastName = Utilities.generateUniqueName(RegisterConstants.DEFAULT_LAST_NAME_PREFIX);
		String email = RegisterConstants.DEFAULT_FIRST_NAME + "." + lastName + RegisterConstants.DEFAULT_EMAIL_SUFFIX;
		String userName = Utilities.generateUniqueName(RegisterConstants.DEFAULT_FIRST_USERNAME_PREFIX);
		String companyID = null;
		if (registrationValid) {
			companyID = RegisterConstants.DEFAULT_COMPANY_ID_VALID;
		}else {
			companyID = RegisterConstants.DEFAULT_COMPANY_ID_INVALID;
		}
		
		registerPage.enterTxtbxFirstName(RegisterConstants.DEFAULT_FIRST_NAME);
		registerPage.enterTxtbxLastName(lastName);
		registerPage.enterTxtbxEmail(email);
		registerPage.enterTxtbxPhoneNumber(RegisterConstants.DEFAULT_PHONE_NUMBER);
		registerPage.enterTxtbxCompanyID(companyID);
		registerPage.enterTxtbxUserName(userName);
		registerPage.getTermsYesRadioBtn().click();	
	}
	
	public static void setupRegistration(RegisterPage registerPage, String userName, boolean registrationValid) {
		String lastName = Utilities.generateUniqueName(RegisterConstants.DEFAULT_LAST_NAME_PREFIX);
		String email = RegisterConstants.DEFAULT_FIRST_NAME + "." + lastName + RegisterConstants.DEFAULT_EMAIL_SUFFIX;
		String companyID = null;
		if (registrationValid) {
			companyID = RegisterConstants.DEFAULT_COMPANY_ID_VALID;
		}else {
			companyID = RegisterConstants.DEFAULT_COMPANY_ID_INVALID;
		}
		
		registerPage.enterTxtbxFirstName(RegisterConstants.DEFAULT_FIRST_NAME);
		registerPage.enterTxtbxLastName(lastName);
		registerPage.enterTxtbxEmail(email);
		registerPage.enterTxtbxPhoneNumber(RegisterConstants.DEFAULT_PHONE_NUMBER);
		registerPage.enterTxtbxCompanyID(companyID);
		registerPage.enterTxtbxUserName(userName);
		registerPage.getTermsYesRadioBtn().click();	
	}

}
