/**
 * 
 */
package com.csnet.pages.home;

/**
 * @author Richard
 *
 */
public class RegisterConstants {
    /*** Account Register Values ***/
    public static final String DEFAULT_FIRST_NAME = "John";
    public static final String DEFAULT_LAST_NAME_PREFIX = "Smith";
    public static final String DEFAULT_FIRST_USERNAME_PREFIX = DEFAULT_FIRST_NAME.substring(0, 1) + DEFAULT_LAST_NAME_PREFIX;
    public static final String DEFAULT_EMAIL_SUFFIX = "@csnet.com";
    public static final String DEFAULT_PHONE_NUMBER = "603-555-1212";
    public static final String DEFAULT_COMPANY_ID_VALID = "netlink3";
    public static final String DEFAULT_COMPANY_ID_INVALID = "abcxyz321";
    
    /*** Failed Registration Error Messages ***/
    public static final String REG_FAIL_HEADER = "Registration Failed!";
    public static final String REG_FAIL_MSG_INVALID_CO_ID = "The company CSNet ID you provided is invalid.";
	public static final String REG_FAIL_MSG_DUP_USERNAME = "The UserName you provided is already in use.";
	public static final String REG_FAIL_MSG_DUP_EMAIL = "The E-Mail address you provided is already in use.";
	public static final String REG_FAIL_MSG_INVALID = "Invalid registration credentials provided.";
	public static final String REG_FAIL_MSG_TERMS_OF_USER = "Registration Denied - Terms of use must be accepted to register!";

}
