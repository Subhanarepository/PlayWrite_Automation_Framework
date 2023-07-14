package com.qa.nxstudio.pages;

import com.microsoft.playwright.Page;

public class LoginPage {

	private Page page;
	
	//1.String Locators
	
	private String loginPageHeading = "//h1[normalize-space()='Sign in']";
	private String email = "input[id='login-email-field']";
	private String password = "input[id='login-password-field']";
	private String signUp_btn = "button[id='user-login-btn']";
	private String forgetPassword_btn = "div[id='forgot-password-btn']";
	private String dashboard_Heading = "//div[@class='module-heading']";
	private String logout_btn = "//div[@class='logOut']//*[name()='svg']";
	
	
	//2. Page Constructor
	public LoginPage(Page page)
	{
		this.page = page;
	}
	
	
	//3. Page actions/methods
	public String getLoginPageTitle()
	{
		String title =  page.title();
		System.out.println("The page title is: "+title);
		return title;
	}
	
	
	public String getLoginPageURL()
	{
		String url =  page.url();
		System.out.println("The page title is: "+url);
		return url;
	}
	
	public boolean loginpageHeadingExist()
	{
		return page.isVisible(loginPageHeading);
	}
	
	
	
	public boolean dologin(String fillEmail, String fillPassword)
	{
		System.out.println("App credentials: " + fillEmail + ":" +  fillPassword);
		page.fill(email, fillEmail);
		page.fill(password, fillPassword);
		page.click(signUp_btn);
		if(page.isVisible(dashboard_Heading))
		{
			System.out.println("User is logged in successfully .....");
			return true;
		}
		return false;
	} 
	
	
	
	public boolean LogOutBtnExist()
	{
		return page.isVisible(logout_btn);
	}
	

}
