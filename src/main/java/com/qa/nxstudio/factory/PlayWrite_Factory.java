package com.qa.nxstudio.factory;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Paths;
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
	
	private static ThreadLocal<Browser> tlBrowser = new ThreadLocal<>();
	private static ThreadLocal<BrowserContext> tlBrowserContext = new ThreadLocal<>();
	private static ThreadLocal<Page> tlPage = new ThreadLocal<>();
	private static ThreadLocal<Playwright> tlPlaywright = new ThreadLocal<>();
	
	
	public static Playwright getPlaywright(){
		return tlPlaywright.get();
	}
	
	
	public static Browser getBrowser(){
		return tlBrowser.get();
	}
	
	public static BrowserContext getBrowserContext(){
		return tlBrowserContext.get();
	}
	
	public static Page getPage(){
		return tlPage.get();
	}
	
	public Page initBrowser(Properties pro)
	{
		
		String browserName = prop.getProperty("browser").trim();
		System.out.println("Browser name is: "+ browserName);
		
		//playwrite = Playwright.create();
		tlPlaywright.set(Playwright.create());
		
		switch (browserName.toLowerCase()) {
		case "chromium":
			//browser = playwrite.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
			tlBrowser.set(getPlaywright().chromium().launch(new BrowserType.LaunchOptions().setHeadless(false)));
			break;

		case "firefox":
			//browser = playwrite.firefox().launch(new BrowserType.LaunchOptions().setHeadless(false));
			tlBrowser.set(getPlaywright().firefox().launch(new BrowserType.LaunchOptions().setHeadless(false)));
			break;
			
		case "safari":
			//browser = playwrite.webkit().launch(new BrowserType.LaunchOptions().setHeadless(false));
			tlBrowser.set(getPlaywright().webkit().launch(new BrowserType.LaunchOptions().setHeadless(false)));
			break;
			
		case "chrome":
			//browser = playwrite.chromium().launch(new LaunchOptions().setChannel("chrome").setHeadless(false));
			tlBrowser.set(getPlaywright().chromium().launch(new LaunchOptions().setChannel("chrome").setHeadless(false)));
			break;
			
		default:
			System.out.println("Please pass the right browser name ....");
			break;
		}
		
		
		tlBrowserContext.set(getBrowser().newContext());
		tlPage.set(getBrowserContext().newPage());
		getPage().navigate(prop.getProperty("url").trim());
		return getPage();
		
		
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
	
	
	
	/**
	 * Take Screenshot
	 */
	
	public static String takeScreenshot() {
		String path = System.getProperty("user.dir")+"/screenshot/" +System.currentTimeMillis() + ".ping";
		
		getPage().screenshot(new Page.ScreenshotOptions()
				.setPath(Paths.get(path))
				.setFullPage(true));
			return path;
				
	}

	
	public String makeVideo() {
		
		String path = System.getProperty("user.dir")+"/testVideo/" +System.currentTimeMillis() + ".mov";
		
		browser.newContext(new Browser.NewContextOptions().setRecordVideoDir(Paths.get("myvideos/")).setRecordVideoSize(640, 480));
		return path;
	}

	
	
}
