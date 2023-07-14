package com.qa.nxstudio.pages;

import com.microsoft.playwright.Page;

public class Dashboard {
	
private Page page;
	
	//1.String Locators
	private String users = "//span[normalize-space()='Users']";
	private String firms = "//span[normalize-space()='Firms']";
	private String repository = "//a[@id='p-accordiontab-0']";
	private String logout_btn = "//div[@class='logOut']//*[name()='svg']";

	
	
	//2. Page Constructor
	public Dashboard(Page page)
	{
		this.page = page;
	}
	
	
	//3. Page actions/methods
	public void usersTabExist()
	{
		page.click(users);
		
	}
	
	public void firmsTabExist()
	{
		page.click(firms);
	}
	
	public void repositoryTabExist()
	{
		page.click(repository);
	}
	
	
	public void clickLogOutBtn()
	{
		page.click(logout_btn);
	}
	

}
