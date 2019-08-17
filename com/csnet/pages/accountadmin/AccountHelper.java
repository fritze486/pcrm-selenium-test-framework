/**
 * 
 */
package com.csnet.pages.accountadmin;

import org.openqa.selenium.WebDriver;

import com.csnet.resources.Utilities;

/**
 * @author Richard
 *
 */
public class AccountHelper {

	public static void setupAccountRequiredFieds(WebDriver driver, AccountDetailsPage accountDetails) {
		String name = Utilities.generateUniqueName(AccountConstants.DEFAULT_ACCNT_NAME_PREFIX);
		String ftpId = Utilities.generateUniqueFtpId("ftpid");
		
		accountDetails.enterTxtbxAccountName(name);
		accountDetails.enterTxtbxCompanyCode(Utilities.randomNumber(4));
		accountDetails.selectStatus(AccountConstants.DEFAULT_ACCNT_STATUS);
		accountDetails.selectDeployStatus(AccountConstants.DEFAULT_ACCNT_DEPLOY_STATUS);
		accountDetails.enterTxtbxMaintExpDate(Utilities.getFutureDate(365));
		accountDetails.enterTxtbxContractDate(Utilities.getTodaysDate());
		accountDetails.enterTxtbxFtpLogin(name);
		accountDetails.enterTxtbxFtpPasswd(name);
		accountDetails.selectSupportLevel(AccountConstants.DEFAULT_ACCNT_SUPPORT_LEVEL);
		accountDetails.enterTxtbxCoverageHours(AccountConstants.DEFAULT_ACCNT_COVERAGE_HOURS);
	}
	
}
