package utility;

import java.io.File;
import java.io.IOException;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class CaptureScreen {

	public static String CaptureScreenShot(WebDriver driver, String ScreenName) {

		String destFileName = "C:\\Users\\vinay\\eclipse-workspace\\vinayak\\Screenshots\\" + ScreenName + System.currentTimeMillis() + ".PNG";
		TakesScreenshot ts = (TakesScreenshot) driver;
		File file = ts.getScreenshotAs(OutputType.FILE);

		try {
			FileUtils.copyFile(file, new File(destFileName));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return destFileName;
	}

}
