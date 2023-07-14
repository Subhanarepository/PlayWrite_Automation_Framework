package com.qa.nxstudio.test;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.qa.nxstudio.base.BaseTest;
import com.qa.nxstudio.constants.AppConstants;


public class LoginPageTest extends BaseTest{
	
	@Test
	public void loginPageTitleTest()
	{
		String actualTitle = loginpage.getLoginPageTitle();
		Assert.assertEquals(actualTitle, AppConstants.LOGIN_PAGE_TITLE);
	}
	
	@Test
	public void loginPageURLTest()
	{
		String actualURL = loginpage.getLoginPageURL();
		Assert.assertEquals(actualURL, prop.getProperty("url"));
	}
	
	
	@Test
	public void loginpageHeadingExist()
	{
		loginpage.loginpageHeadingExist();
		System.out.println("The user is on login screen...");
	}
	
	
	@Test
	public void validCredentials()
	{
		loginpage.dologin(prop.getProperty("email").trim(), prop.getProperty("password").trim());
	}
	
	
	
	
	/*
	 * @Test public void logoutBtnLogoutTest() {
	 * Assert.assertTrue(loginpage.LogOutBtnExist());
	 * 
	 * }
	 */
	
	
	/*
	 * @Test public void dashboardPageHeadingTest() { String
	 * actualDashboadPageHeading = loginpage.getDashboadPageHeading("Projects");
	 * Assert.assertEquals(actualDashboadPageHeading, "Projects"); }
	 */
	

}
