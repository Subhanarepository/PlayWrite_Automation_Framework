package com.qa.nxstudio.factory;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserContext;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.BrowserType.LaunchOptions;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

public class PlayWrite_Factory {

	Playwright playwrite;
	Browser browser;
	BrowserContext browserContext;
	Page page;
	Properties prop;
	
	public Page initBrowser(Properties pro)
	{
		
		String browserName = prop.getProperty("browser").trim();
		System.out.println("Browser name is: "+ browserName);
		playwrite = Playwright.create();
		
		switch (browserName.toLowerCase()) {
		case "chromium":
			browser = playwrite.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
			break;

		case "firefox":
			browser = playwrite.firefox().launch(new BrowserType.LaunchOptions().setHeadless(false));
			break;
			
		case "safari":
			browser = playwrite.webkit().launch(new BrowserType.LaunchOptions().setHeadless(false));
			break;
			
		case "chrome":
			browser = playwrite.chromium().launch(new LaunchOptions().setChannel("chrome").setHeadless(false));
			break;
			
		default:
			System.out.println("Please pass the right browser name ....");
			break;
		}
		
		browserContext	= browser.newContext();
		page = browserContext.newPage();
		page.navigate(prop.getProperty("url").trim());
		
		return page;
	}
	
	/**
	 * This method is used to initiazise the properties from the config file
	 * @throws IOException 
	 */
	
	public Properties initprop() throws IOException {
		
		try {
			FileInputStream ip = new FileInputStream("./src/test/resources/config/config.properties");
			prop = new Properties();
			prop.load(ip);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return prop;
	}
	
	
	
}
