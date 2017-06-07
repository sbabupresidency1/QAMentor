package qa.qamentor.CommonMethods;

import java.io.File;
import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.sikuli.script.FindFailed;
import org.sikuli.script.Pattern;
import org.sikuli.script.Screen;

public class chrome
{
	
	
	public static void main(String[] args) throws IOException, InterruptedException, FindFailed {
		
		System.setProperty("webdriver.chrome.driver", "src/main/resources/drivers/chromedriver.exe");
		ChromeOptions options = new ChromeOptions();
		options.addExtensions(new File("C:\\workspace\\QAmentor\\qamentor\\lib\\Etihad-Guest-Reward-Card_v4.0.crx"));
		DesiredCapabilities capabilities = new DesiredCapabilities();
		capabilities.setCapability(ChromeOptions.CAPABILITY, options);
		WebDriver driver = new ChromeDriver(capabilities);
		//WebDriver driver = new FirefoxDriver(firefoxprofile);

		driver.get("http://www.google.com");

		

		String Path = "";
		Screen screen = new Screen();		
		Pattern logo = new Pattern("C:\\workspace\\QAmentor\\QA\\testcases\\UploadFiles\\Download\\QA.png");
		screen.wait(logo, 2000);
		screen.click(logo); 
		
		Pattern x = new Pattern("C:\\workspace\\QAmentor\\QA\\testcases\\UploadFiles\\Download\\X.png");
		screen.wait(x, 2000);
		screen.click(x);
	
	}

}
