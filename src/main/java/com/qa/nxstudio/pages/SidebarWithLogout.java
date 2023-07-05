package com.qa.nxstudio.pages;

import com.microsoft.playwright.Page;

public class SidebarWithLogout {
	
private Page page;
	
	//1.String Locators
	private String user = "//span[normalize-space()='Users']";
	private String firm = "//span[normalize-space()='Firms']";
	private String repository = "//a[@id='p-accordiontab-0']";
	private String logout_btn = "//div[@class='logOut']//*[name()='svg']";

	
	
	//2. Page Constructor
	public SidebarWithLogout(Page page)
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

}
