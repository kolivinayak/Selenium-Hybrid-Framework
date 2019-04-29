package webpages;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage {
    WebDriver driver;

    public LoginPage(WebDriver ldriver) {
        driver = ldriver;
    }

    @FindBy(xpath = "//*[text()=' Account']")  WebElement accountLink;
    @FindBy(xpath = "//input[@name='email']")  WebElement emailLink;
    @FindBy(xpath = "//input[@name='password']")  WebElement passwordLink;
    @FindBy(xpath = "//button[text()='Login']")  WebElement loginButton;
    @FindBy(xpath = "//*[@id='mdLeftSidebar']//a[text()='Log Off']")  WebElement LogoutLink;
    @FindBy(xpath = "//*[text()='Account Logout']")  WebElement LogoutText1;
    By LogoutText = new By.ByXPath(" //*[@id='bd']//*[text()='Account Logout']");


    @FindBy(xpath = "//*[text()='You have been logged off your account. It is now safe to leave the computer.']")  WebElement LogoutTextDetails;

    public void clickOnAccountLink(){
        accountLink.click();
    }

    public void enterEmailID(String email){
        emailLink.sendKeys(email);
    }

    public void enterPassword(String password){
        passwordLink.sendKeys(password);
    }

    public void loginToApplication(String email, String password){
        emailLink.sendKeys(email);
        passwordLink.sendKeys(password);
    }

    public void clickOnLoginButton(){
        loginButton.click();
    }

    public void clickOnLogOutLink(){
        LogoutLink.click();
    }

    public boolean isLogoutTextDisplayed(){

        WebDriverWait wt=new WebDriverWait(driver,60);
        WebElement el = wt.until(ExpectedConditions.presenceOfElementLocated(LogoutText));
        return el.isDisplayed();
//        return LogoutText1.isDisplayed();

    }

    public String getLogOutText(){
      return LogoutText1.getText();
    }


}