package dataprovider;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Properties;

public class ConfigDataProvider {

	Properties pr = new Properties();
	public String url;

	public ConfigDataProvider() {

		File src = new File("./Configurations/Configuration.properties");

		try {
			FileInputStream fis = new FileInputStream(src);
			pr.load(fis);
		} catch (Exception e) {
			System.out.println("The exeception is " + e.getMessage());
		}
	}

	public String getApplicationUrl(){
		
		return pr.getProperty("url");
		
	}
	
	
	public String getChromPath() {
		return pr.getProperty("chromePath");
	}
	

	public String getMicroEdgePath() {
		return pr.getProperty("microEdge");
	}
	
	
}
