package factory;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class BrowserFactory {

	static WebDriver driver;

	public static WebDriver getBrowser(String browserName) {

		try {
			if (browserName.equalsIgnoreCase("Firfox")) {
				driver = new FirefoxDriver();
			} else if (browserName.equalsIgnoreCase("Chrome")) {
				//System.out.println("The driver is "+ DataProviderFactory.getConfig().getChromPath());
				System.setProperty("webdriver.chrome.driver", DataProviderFactory.getConfig().getChromPath());
				driver = new ChromeDriver();
			} else if (browserName.equalsIgnoreCase("MicroEdge")) {
				System.setProperty("webdriver.edge.driver", DataProviderFactory.getConfig().getMicroEdgePath());
				driver = new EdgeDriver();
			}
		} catch (Exception e) {
			System.out.println("The exception is "+e.getMessage());
		}

		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		
		return driver;
	}

	public static void closeDriver(WebDriver driver) {
		driver.quit();
	}

}
