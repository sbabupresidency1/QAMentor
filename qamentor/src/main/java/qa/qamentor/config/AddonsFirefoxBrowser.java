package qa.qamentor.config;

import java.io.File;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.openqa.selenium.WebDriver;
 
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;



/**
 * Class to configure and get Details for Firefox Browser
 * @author babu.sathiyaraja
 * 
 */
public class AddonsFirefoxBrowser implements Browser {

	private WebDriver firefoxDriver;
	private DesiredCapabilities caps;
	public static final Log log = LogFactory
			.getLog(qa.qamentor.config.AddonsFirefoxBrowser.class);

	public AddonsFirefoxBrowser() throws Exception  {
	
		/*String OSName=Platform.OS.toUpperCase();
		if(OSName.contains("WINDOWS")){
			System.setProperty(ApplicationConstants.GECKO_DRIVER_NAME,ApplicationConstants.GECKO_DRIVER_PATH_WINDOWS);

		}
		else if(OSName.contains("MAC")){
			System.setProperty(ApplicationConstants.GECKO_DRIVER_NAME,ApplicationConstants.GECKO_DRIVER_PATH_MAC_OS);

		}	*/	
		log.info("Calling FirefoxBrowser constructor and return Firefox Driver Object");
		File firebug_path = new File("C:\\workspace\\QAmentor\\qamentor\\lib\\etihad_guest_reward_card-2.2-fx.xpi");  
		FirefoxProfile firefoxprofile = new FirefoxProfile();
		firefoxprofile.addExtension(firebug_path);
		//WebDriver driver = new FirefoxDriver(firefoxprofile);		
		firefoxDriver = new FirefoxDriver(firefoxprofile);

	}

	public String getBrowserName() {
		return ((RemoteWebDriver) firefoxDriver).getCapabilities()
				.getBrowserName();
	}

	public String getVersion() {
		return ((RemoteWebDriver) firefoxDriver).getCapabilities().getVersion();
	}

	public WebDriver getDriver() {
		return firefoxDriver;
	}

}
