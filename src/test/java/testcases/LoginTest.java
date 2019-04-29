package testcases;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;


import factory.BrowserFactory;
import factory.DataProviderFactory;

public class LoginTest {

    WebDriver driver;


    @BeforeMethod
    public void init() {
        driver = BrowserFactory.getBrowser("chrome");
        // driver.get(DataProviderFactory.getConfig().getApplicationUrl());
    }


    @Test
    public void LoginTest1() {
        try {
            driver.navigate().to(DataProviderFactory.getConfig().getApplicationUrl());

            webpages.LoginPage lp= PageFactory.initElements(driver, webpages.LoginPage.class);

            lp.clickOnAccountLink();

            String email = DataProviderFactory.getExcel().getData(0,0,0);
            String passwd = DataProviderFactory.getExcel().getData(0,0,1);

            System.out.println("email "+email+" password "+passwd);
            
            lp.loginToApplication(DataProviderFactory.getExcel().getData(0,0,0),DataProviderFactory.getExcel().getData(0,0,1));
//            lp.loginToApplication(email,passwd);

            lp.clickOnLoginButton();
            
            
            
            lp.clickOnLogOutLink();

            Assert.assertTrue(lp.isLogoutTextDisplayed(),"Failed to verify Log Out Text");


        } catch (Exception e) {
            System.out.println("The exception is in Test "+e.getMessage());
            e.printStackTrace();
        }

    }




    @AfterTest
    public void end() {
        BrowserFactory.closeDriver(driver);
    }


}
