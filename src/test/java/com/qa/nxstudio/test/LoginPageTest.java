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
	public void validCredentials()
	{
		loginpage.setEmail("subhna.khan@digivalet.com");
		loginpage.setPassword("CasaDigi@4.0");
		loginpage.clickSignUpBtn();
	}
	
	
	
	@Test
	public void invalidCredentials()
	{
		loginpage.setEmail("subhna@digivalet.com");
		loginpage.setPassword("CasaDigi");
		loginpage.clickSignUpBtn();
	}
	
	
	@Test
	public void blankCredentials()
	{
		loginpage.setEmail("");
		loginpage.setPassword("");
		loginpage.clickSignUpBtn();
	}
	
	
	@Test
	public void dashboardPageHeadingTest()
	{
		String actualDashboadPageHeading = loginpage.getDashboadPageHeading("Projects");
		Assert.assertEquals(actualDashboadPageHeading, "Projects");
	}
	

}
