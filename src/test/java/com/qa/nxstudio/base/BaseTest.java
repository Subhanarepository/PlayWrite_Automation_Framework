package com.qa.nxstudio.base;

import java.io.IOException;
import java.util.Properties;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import com.microsoft.playwright.Page;
import com.qa.nxstudio.factory.PlayWrite_Factory;
import com.qa.nxstudio.pages.LoginPage;

public class BaseTest {
	
	PlayWrite_Factory pf;
	Page page;
	protected Properties prop;
	protected LoginPage loginpage;
	
	
	
	@BeforeTest
	public void setUp() throws IOException
	{
		pf= new PlayWrite_Factory();
		prop = pf.initprop();
		page = pf.initBrowser(prop);
		loginpage = new LoginPage(page);
		
	}
	
	
	@AfterTest
	public void teatDown()
	{
		page.context().browser().close();
	}

}
