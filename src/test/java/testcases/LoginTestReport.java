package testcases;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import factory.BrowserFactory;
import factory.DataProviderFactory;
import utility.CaptureScreen;

public class LoginTestReport {

	WebDriver driver;
	ExtentReports report;
	ExtentTest extendTest;
	boolean TestStatus = false;

	@BeforeMethod
	public void init() {
		driver = BrowserFactory.getBrowser("chrome");
		report = new ExtentReports(".\\Reports\\ReportLogin.html", true);
		extendTest = report.startTest("Login and logout Test", "This will test both login and logout feature");
		extendTest.log(LogStatus.INFO, "Intilization done successfully");
	}

	@Test
	public void LoginTest1() {
		try {
			driver.navigate().to(DataProviderFactory.getConfig().getApplicationUrl());

			webpages.LoginPage lp = PageFactory.initElements(driver, webpages.LoginPage.class);

			lp.clickOnAccountLink();
			extendTest.log(LogStatus.PASS, "Account link click done successfully");

//			String email = DataProviderFactory.getExcel().getData(0, 0, 0);
//			String passwd = DataProviderFactory.getExcel().getData(0, 0, 1);
//
//			System.out.println("email " + email + " password " + passwd);

			lp.loginToApplication(DataProviderFactory.getExcel().getData(0, 0, 0),
					DataProviderFactory.getExcel().getData(0, 0, 1));
			extendTest.log(LogStatus.INFO, "Email and password read from excel successfully");

			lp.clickOnLoginButton();
			extendTest.log(LogStatus.PASS, "Login to application is successfully");
			extendTest.log(LogStatus.INFO, extendTest.addScreenCapture(CaptureScreen.CaptureScreenShot(driver, "Login")));

			lp.clickOnLogOutLink();
			extendTest.log(LogStatus.INFO, "Logout click done successfully");

			Assert.assertTrue(lp.isLogoutTextDisplayed(), "Failed to verify Log Out Text");
			extendTest.log(LogStatus.PASS, "Log out test is  done successfully");
//			logger.log(LogStatus.INFO, logger.addScreenCapture(CaptureScreen.CaptureScreenShot(driver, "Logout")));

		} catch (Exception e) {
			System.out.println("The exception is in Test " + e.getMessage());
			e.printStackTrace();
			TestStatus = true;
		} finally {
			if (TestStatus) {
				extendTest.log(LogStatus.FAIL, "Log out test is not done successfully");
				extendTest.log(LogStatus.FAIL, extendTest.addScreenCapture(CaptureScreen.CaptureScreenShot(driver, "LoginTest")));
			}
		}

	}

	@AfterTest
	public void end() {
			report.endTest(extendTest);
			report.flush();
			BrowserFactory.closeDriver(driver);
		}
	
}

