
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.sikuli.script.FindFailed;
import org.sikuli.script.Pattern;
import org.sikuli.script.Screen;

import qa.qamentor.utils.Directory;

public class IEBrowser {
public static void main(String[] args) throws Exception{
  /*final DesiredCapabilities caps = DesiredCapabilities.internetExplorer();
     caps.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);
  System.setProperty("webdriver.ie.driver", "C:/workspace/QAmentor/qamentor/src/main/resources/drivers/IEDriverServer.exe");
  WebDriver driver = new InternetExplorerDriver();
  driver.manage().window().maximize();
  driver.get("http://www.edocketspro.com/");
  Thread.sleep(5000);
  type("LoginPassword.png","America1*");
  click("LoginOKButton.png");
  driver.quit();*/
	
	  final DesiredCapabilities caps = DesiredCapabilities.internetExplorer();
	     caps.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);
	  System.setProperty("webdriver.ie.driver", "C:/workspace/QAmentor/qamentor/src/main/resources/drivers/IEDriverServer.exe");
	  WebDriver driver = new InternetExplorerDriver();
	  driver.manage().window().maximize();
	  driver.get("https://www.facebook.com/");
	  WebElement email=driver.findElement(By.xpath("//input[@name='email']"));
	  email.sendKeys("ramya.palaniswamy17@gmail.com");
	  WebElement pass=driver.findElement(By.xpath("//input[@name='pass']"));
	  pass.sendKeys("abc");
	  driver.findElement(By.xpath("//input[@value='Log In']")).click();
	  driver.quit();
}


public static void click(String image) throws FindFailed {
	String Path = Directory.uploadFilePath+"\\SikuliImages\\"+image;
	Screen screen = new Screen();		
	Pattern pattern = new Pattern(Path);
	screen.wait(pattern, 3000);
	screen.click(pattern); 
}

public static void type(String image , String Value) throws FindFailed {
	String Path = Directory.uploadFilePath+"\\SikuliImages\\"+image;
	Screen screen = new Screen();		
	Pattern pattern = new Pattern(Path);
	screen.wait(pattern, 4000);
	screen.type(pattern, Value); 
}
}