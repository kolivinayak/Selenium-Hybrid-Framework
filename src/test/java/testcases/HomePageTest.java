package testcases;



import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import factory.BrowserFactory;
import factory.DataProviderFactory;

import webpages.HomePage;

public class HomePageTest {

	WebDriver driver;

	
	@BeforeMethod
	public void init() {
		driver = BrowserFactory.getBrowser("Chrome");
		// driver.get(DataProviderFactory.getConfig().getApplicationUrl());
	}

	@Test
	public void homePagetest() {
		driver.navigate().to(DataProviderFactory.getConfig().getApplicationUrl());
		HomePage hp = PageFactory.initElements(driver, HomePage.class);
		String homePageTitle = hp.getHomePageTitle();
		System.out.println("Title is "+homePageTitle);
		org.testng.Assert.assertTrue(homePageTitle.contains("Business suit Shop"), "Home page title successfully not verified ");

	}

	@AfterTest
	public void end() {
		BrowserFactory.closeDriver(driver);
	}

}
