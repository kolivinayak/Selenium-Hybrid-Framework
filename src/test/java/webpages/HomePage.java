package webpages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage {

WebDriver driver;
	
	@FindBy(xpath="//*[text()=' Account']" ) WebElement signInLink;
	@FindBy(xpath="//*[@id='cart_total']" ) WebElement cartLink;
	@FindBy(xpath="//img[@src='/userdata/store3/90386/image/data/201403/logo4.png']" ) WebElement homeLogoImg;
	@FindBy(xpath="//*[@id='topmenu']/li[1]") WebElement homeLink;
	
	public HomePage(WebDriver ldrvier) {
		
		driver = ldrvier;

	}
	
	public void clickOnHomeLogo() {
		homeLogoImg.click();
	}
	
	public void clickOnsignInLink() {
		signInLink.click();
	}
	public void clickOnscartLink() {
		cartLink.click();
	}
	public void clickOnhomeLink() {
		homeLink.click();
	}
	
	public String getHomePageTitle() {
		return driver.getTitle();
	}
	
}
