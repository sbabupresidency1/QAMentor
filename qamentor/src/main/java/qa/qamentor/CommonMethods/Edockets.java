package qa.qamentor.CommonMethods;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.sikuli.script.FindFailed;
import org.sikuli.script.Pattern;
import org.sikuli.script.Screen;
import org.sikuli.script.SikuliException;

import qa.qamentor.commands.Manipulation;
import qa.qamentor.commands.Navigate;
import qa.qamentor.commands.OR;
import qa.qamentor.commands.SikuliActions;
import qa.qamentor.utils.Directory;

public class Edockets extends Manipulation implements OR
{
	public static void edocketLogIn(WebDriver driver) throws AWTException, SikuliException {
		 // driver.get("http://www.edocketspro.com/");
		  if(Directory.browser.equalsIgnoreCase("firefox")) {
		   SikuliActions.type("FFUserName.PNG","babu@edocketspro.com");
		   wait(driver,"3");
		   SikuliActions.type("FFPassword.PNG","America1*");	
		   wait(driver,"3");
		  }
		  else if(Directory.browser.equalsIgnoreCase("ie")) {
		   SikuliActions.type("Password.PNG","America1*");
		   
		  } 
		 }

	public static void click(String image) throws FindFailed
	{
		String Path = "C:\\workspace\\QAmentor\\QA\\testcases\\UploadFiles\\Download\\"+image;
		Screen screen = new Screen();		
		Pattern logo = new Pattern(Path);
		screen.wait(logo, 3000);
		screen.click(logo); 
	}

	public static void type(String image , String Value) throws FindFailed
	{
		String Path = "C:\\workspace\\QAmentor\\QA\\testcases\\UploadFiles\\Download\\"+image;
		Screen screen = new Screen();		
		Pattern username = new Pattern(Path);
		screen.wait(username, 4000);
		screen.type(username, Value); 
	}

	public static void EdocketsLoging(WebDriver driver) throws Exception {
		Navigate.get(driver, "http://34.197.155.14/?login=devadmin&password=p@ssw0rd&remember=1");
		//Navigate.get(driver, "http://34.197.155.14/");
		wait(driver, "4");
		//Navigate.maximize(driver);
		type("PopUpUserName.png", "devadmin");
		wait(driver, "3");
		type("PopUpPassword.png", "p@ssw0rd");
		wait(driver, "3");
		click("OKButton.png");
		wait(driver, "4");
	}

	public static void doubleclick(WebDriver driver, WebElement webElement) {

		try
		{
			if(driver.findElement(By.xpath("//span[@class='rbSecondaryIcon rbNext']")).isDisplayed()) 
			{
				driver.findElement(By.xpath("//span[@class='rbSecondaryIcon rbNext']")).click(); 
				try {Thread.sleep(4000);} catch (InterruptedException e) {e.printStackTrace();}				
				try
				{
					if(driver.findElement(By.xpath("//span[@class='rbSecondaryIcon rbNext']")).isDisplayed()) 
					{
						driver.findElement(By.xpath("//span[@class='rbSecondaryIcon rbNext']")).click();
						try {Thread.sleep(4000);} catch (InterruptedException e) {e.printStackTrace();}
					} 					
				}
				catch(Exception e)
				{					
				}				
			} 
		}
		catch(Exception e)
		{
		}
	}

	public static void jsClickByXPath(WebDriver driver,String NormalXpath) {
		WebElement element = driver.findElement(By.xpath(NormalXpath));
		JavascriptExecutor executor = (JavascriptExecutor)driver;
		executor.executeScript("arguments[0].click();", element);
	}

	public static void closeTab(WebDriver driver) {				
		driver.findElement(By.xpath("//div[@id='Tabs_header']//span[text()='Home']")).click(); 			
		wait(driver, "3");
		driver.findElement(By.xpath("//html/body/form/div[3]/div[2]/div/div[1]/span[6]/span/span/div")).click(); 			
		wait(driver, "2");				
		jsClickByXPath(driver, "//a[@class='tabLink']");
		wait(driver, "3");
		System.out.print("Clicked 1");			
		driver.findElement(By.xpath("//div[@id='Tabs_header']//span[text()='Home']")).click(); 			
		wait(driver, "3");
		System.out.print("Clicked 5");		
	}
	
	public static void eDocketLogin() throws Exception {	
		Robot robot = new Robot();
		robot.keyPress(KeyEvent.VK_B);
		robot.keyRelease(KeyEvent.VK_B);
		robot.keyPress(KeyEvent.VK_A);
		robot.keyRelease(KeyEvent.VK_A);
		robot.keyPress(KeyEvent.VK_B);
		robot.keyRelease(KeyEvent.VK_B);
		robot.keyPress(KeyEvent.VK_U);
		robot.keyRelease(KeyEvent.VK_U);
		robot.keyPress(KeyEvent.VK_AT);
		robot.keyRelease(KeyEvent.VK_AT);
		robot.keyPress(KeyEvent.VK_E);
		robot.keyRelease(KeyEvent.VK_E);
		robot.keyPress(KeyEvent.VK_D);
		robot.keyRelease(KeyEvent.VK_D);
		robot.keyPress(KeyEvent.VK_O);
		robot.keyRelease(KeyEvent.VK_O);
		robot.keyPress(KeyEvent.VK_K);
		robot.keyRelease(KeyEvent.VK_K);
		robot.keyPress(KeyEvent.VK_E);
		robot.keyRelease(KeyEvent.VK_E);
		robot.keyPress(KeyEvent.VK_T);
		robot.keyRelease(KeyEvent.VK_T);
		robot.keyPress(KeyEvent.VK_S);
		robot.keyRelease(KeyEvent.VK_S);
		robot.keyPress(KeyEvent.VK_P);
		robot.keyRelease(KeyEvent.VK_P);
		robot.keyPress(KeyEvent.VK_R);
		robot.keyRelease(KeyEvent.VK_R);
		robot.keyPress(KeyEvent.VK_O);
		robot.keyRelease(KeyEvent.VK_O);
		robot.keyPress(KeyEvent.VK_PERIOD);
		robot.keyRelease(KeyEvent.VK_PERIOD);
		robot.keyPress(KeyEvent.VK_C);
		robot.keyRelease(KeyEvent.VK_C);
		robot.keyPress(KeyEvent.VK_O);
		robot.keyRelease(KeyEvent.VK_O);
		robot.keyPress(KeyEvent.VK_M);
		robot.keyRelease(KeyEvent.VK_M);
		//robot.keyPress(KeyEvent.);
		robot.delay(3000);
		robot.keyPress(KeyEvent.VK_TAB);
		robot.keyRelease(KeyEvent.VK_TAB);
		robot.delay(3000);
		robot.keyPress(KeyEvent.VK_A);
		robot.keyRelease(KeyEvent.VK_A);
		robot.keyPress(KeyEvent.VK_M);
		robot.keyRelease(KeyEvent.VK_M);
		robot.keyPress(KeyEvent.VK_E);
		robot.keyRelease(KeyEvent.VK_E);
		robot.keyPress(KeyEvent.VK_R);
		robot.keyRelease(KeyEvent.VK_R);
		robot.keyPress(KeyEvent.VK_I);
		robot.keyRelease(KeyEvent.VK_I);
		robot.keyPress(KeyEvent.VK_C);
		robot.keyRelease(KeyEvent.VK_C);
		robot.keyPress(KeyEvent.VK_A);
		robot.keyRelease(KeyEvent.VK_A);
		robot.keyPress(KeyEvent.VK_1);
		robot.keyRelease(KeyEvent.VK_1);
		//robot.keyPress(KeyEvent.);
		robot.keyPress(KeyEvent.VK_CONTROL);
		robot.keyPress(KeyEvent.VK_SHIFT);
		robot.keyRelease(KeyEvent.VK_8);
		robot.keyPress(KeyEvent.VK_SHIFT);
		robot.keyRelease(KeyEvent.VK_8);
		robot.keyRelease(KeyEvent.VK_CONTROL);
		robot.delay(1000);
		robot.keyPress(KeyEvent.VK_ENTER);
		robot.keyRelease(KeyEvent.VK_ENTER);
	}

}
