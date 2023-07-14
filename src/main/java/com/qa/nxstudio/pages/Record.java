package com.qa.nxstudio.pages;
import com.microsoft.playwright.*;
import com.microsoft.playwright.options.*;
import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;
import java.util.*;

public class Record {

	public static void main(String[] args) {
		
		
		 try (Playwright playwright = Playwright.create()) {
		      Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions()
		        .setHeadless(false));
		      BrowserContext context = browser.newContext();
		      Page page = context.newPage();
		      page.navigate("https://nxcasadigi-studio-qa.project.casadigi.com/login");
		      page.getByPlaceholder("Enter your email").fill("subhana.khan@digivalet.com");
		      page.getByPlaceholder("••••••••").click();
		      page.getByPlaceholder("••••••••").press("CapsLock");
		      page.getByPlaceholder("••••••••").fill("C");
		      page.getByPlaceholder("••••••••").press("CapsLock");
		      page.getByPlaceholder("••••••••").fill("Casa");
		      page.getByPlaceholder("••••••••").press("CapsLock");
		      page.getByPlaceholder("••••••••").fill("CasaD");
		      page.getByPlaceholder("••••••••").press("CapsLock");
		      page.getByPlaceholder("••••••••").fill("CasaDigi@4.0");
		      page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Sign in")).click();
		      page.locator(".user-svg-icon").first().click();
		      page.locator("div:nth-child(3) > .itemWrapper > .iconWrapper > .user-svg-icon > use").click();
		      page.locator("#p-accordiontab-0").click();
		      page.navigate("https://nxcasadigi-studio-qa.project.casadigi.com/firm");
		    }
		

	}

}
