package com.qa.nxstudio.pages;

import com.microsoft.playwright.Page;

public class LoginPage {

	private Page page;
	
	//1.String Locators
	private String email = "input[id='login-email-field']";
	private String password = "input[id='login-password-field']";
	private String signUp_btn = "button[id='user-login-btn']";
	private String forgetPassword_btn = "div[id='forgot-password-btn']";
	private String dashboard_Heading = "div[class='module-heading']";
	
	
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
	
	
	public void setEmail(String fillEmail)
	{
		page.fill(email, fillEmail);
	}
	
	
	public void setPassword(String fillPassword)
	{
		page.fill(password, fillPassword);
	}
	
	
	public void clickSignUpBtn()
	{
		page.click(signUp_btn);
		/*
		 * String heading = page.textContent(dashboard_Heading);
		 * System.out.println("Dashoard heading is:" +heading); return heading;
		 */
	}
	
	
	
	
	
	public String getDashboadPageHeading(String Heading) 
	{
		String DashboadHeading = page.textContent("dashboard_Heading");
		System.out.println("Dashboad Heading" +DashboadHeading);
		return DashboadHeading; 
	}
}
