package qa.qamentor.commands;

import io.appium.java_client.android.AndroidDriver;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.Point;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import qa.qamentor.config.IEBrowser;
import qa.qamentor.util.CommandUtils;
import qa.qamentor.utils.Directory;
import qa.qamentor.utils.Platform;

//import com.thoughtworks.selenium.webdriven.commands.WaitForPopup;

public class Manipulation extends CommandUtils implements OR {

	static Logger log = Logger.getLogger(Manipulation.class.getName());
	public static String ElementWait=Directory.WaitFor;
	public static int WaitElementSeconds=new Integer(ElementWait);
	public static AndroidDriver adriver;

	public static void click(WebElement webElement) {
		try {
			if(webElement.isDisplayed()) {
				webElement.click();    	    	   
			}    	   
		} 
		catch (StaleElementReferenceException e){ }
	}

	public static void jsClickByXPath(WebDriver driver,String NormalXpath) {
		WebElement element = driver.findElement(By.xpath(NormalXpath));
		JavascriptExecutor executor = (JavascriptExecutor)driver;
		executor.executeScript("arguments[0].click();", element);
	}

	public static void jsTypeByXPath(WebDriver driver,String NormalXpath,String input) {
		WebElement element = driver.findElement(By.xpath(NormalXpath));
		JavascriptExecutor executor = (JavascriptExecutor)driver;
		executor.executeScript("arguments[0].value='"+input+"';", element);
	}

	public static void aclick(AndroidDriver driver, WebElement webElement) {
		try
		{
			if(webElement.isDisplayed()) {
				webElement.click();    	    	   
			}    	
		}
		catch (Exception e)
		{

		}
	}

	public static void actionClick(WebDriver driver, WebElement webElement) {
		try {
			if(Directory.browser.equalsIgnoreCase("firefox")){	
				if(webElement.isEnabled()){
					webElement.click(); 	 
				}   
			} else if(webElement.isEnabled()) {
				Actions action = new Actions(driver);
				action.click(webElement).build().perform();     	    	 
			}    	   
		} catch (StaleElementReferenceException e) { }
	}

	public static CharSequence[] actionType(WebDriver driver,WebElement webElement,CharSequence... keysToSend){
		try {
			if(Directory.browser.equalsIgnoreCase("firefox")){	
				if(webElement.isEnabled()){
					webElement.sendKeys(keysToSend);    	 
				}   
			}else if(webElement.isEnabled()){
				Actions action = new Actions(driver);
				action.sendKeys(webElement, keysToSend).build().perform();    	    	 
			}    	   
		} catch (StaleElementReferenceException e) { }
		return keysToSend;
	}

	public static void doubleClick(WebDriver driver, WebElement webElement) {
		try {
			Actions action = new Actions(driver).doubleClick(webElement);
			action.build().perform();
		} catch (StaleElementReferenceException e) {
			log.info("Element is not attached to the page document "
					+ e.getStackTrace());
		} catch (NoSuchElementException e) {
			log.info("Element " + webElement + " was not found in DOM "
					+ e.getStackTrace());
		} catch (Exception e) {
			log.info("Element " + webElement + " was not clickable "
					+ e.getStackTrace());
		}
	}

	public static void clickAt(WebDriver driver, WebElement webElement, int x,int y) {
		try {
			Actions builder = new Actions(driver);
			builder.moveToElement(webElement, x, y).click().build().perform();
		} catch (StaleElementReferenceException e) {
			log.info("Element is not attached to the page document "
					+ e.getStackTrace());
		} catch (NoSuchElementException e) {
			log.info("Element " + webElement + " was not found in DOM "
					+ e.getStackTrace());
		} catch (Exception e) {
			log.info("Element " + webElement + " was not clickable "
					+ e.getStackTrace());
		}
	}

	public static void clickAndHold(WebDriver driver,WebElement webElement)	{
		try {
			Actions builder = new Actions(driver);
			builder.clickAndHold(webElement).build().perform();
		} catch (StaleElementReferenceException e) {
			log.info("Element is not attached to the page document "
					+ e.getStackTrace());
		} catch (NoSuchElementException e) {
			log.info("Element " + webElement + " was not found in DOM "
					+ e.getStackTrace());
		} catch (Exception e) {
			log.info("Element " + webElement + " was not clickable "
					+ e.getStackTrace());
		}
	}

	public static void clear(WebElement webElement) {
		webElement.clear();
	}
	public static void actionClear(WebDriver driver,WebElement webElement) {
		if(Directory.browser.equalsIgnoreCase("firefox")){	
			if(webElement.isEnabled()){
				webElement.sendKeys(Keys.chord(Keys.CONTROL, "a"), "55");
				webElement.clear();
			}   
		}else{
			webElement.click();
			Actions action = new Actions(driver); 
			webElement.sendKeys(Keys.chord(Keys.CONTROL, "a"), "55");
			action.sendKeys(Keys.DELETE);
		}
	}
	public static String clearAndType(WebElement webElement, String keysToSend) {
		webElement.clear();
		try{Thread.sleep(3000);}catch(InterruptedException e){e.printStackTrace();}
		webElement.sendKeys(keysToSend);		
		return keysToSend;
	}
	
	public static String sendKeys(WebElement webElement,String keysToSend) {
		webElement.sendKeys(keysToSend);
		//try {Thread.sleep(1000);} catch (InterruptedException e) {e.printStackTrace();}
		return keysToSend;
	} 

	public static void submit(WebElement webElement) {
		webElement.submit();
	}

	public static void keyDown(Actions actions, Keys keys) {
		actions.keyDown(keys);
	}

	public static void keyUp(Actions actions, Keys keys) {
		actions.keyUp(keys);
	}

	public static String getCurrentURL(WebDriver driver) {
		return driver.getCurrentUrl();
	}

	public static String getTitle(WebDriver driver) {
		return driver.getTitle();
	}

	public static void mouseOver(WebDriver driver, WebElement webElement) {
		try {
			Actions builder = new Actions(driver);
			builder.moveToElement(webElement).build().perform();
		} catch (StaleElementReferenceException e) {
			log.info("Element is not attached to the page document "
					+ e.getStackTrace());
		} catch (NoSuchElementException e) {
			log.info("Element " + webElement + " was not found in DOM "
					+ e.getStackTrace());
		} catch (Exception e) {
			log.info("Element " + webElement + " was not mouseOver "
					+ e.getStackTrace());
		}
	}

	public static void mouseOverAndClick(WebDriver driver, WebElement webElement) {
		try {
			Actions builder = new Actions(driver);
			builder.moveToElement(webElement).click().build().perform();
		} catch (StaleElementReferenceException e) {
			log.info("Element is not attached to the page document "
					+ e.getStackTrace());
		} catch (NoSuchElementException e) {
			log.info("Element " + webElement + " was not found in DOM "
					+ e.getStackTrace());
		} catch (Exception e) {
			log.info("Element " + webElement + " was not mouseOver "
					+ e.getStackTrace());
		}
	}

	public static void selectCheckBox(WebElement element) {
		try {
			if (element.isSelected()) {
				log.info("Checkbox: " + element + "is already selected");
			} else {
				element.click();
			}
		} catch (Exception e) {
			log.info("Unable to select the checkbox: " + element);
		}
	}

	public static void deSelectCheckBox(WebElement element) {
		try {
			if (element.isSelected()) {
				element.click();
			} else {
				log.info("Checkbox: " + element + "is already deselected");
			}
		} catch (Exception e) {
			log.info("Unable to deselect checkbox: " + element);
		}
	}

	public static void selectByIndex(WebElement element, String inputData) {
		try {
			Integer index = new Integer(inputData);
			Select selectBox = new Select(element);
			selectBox.selectByIndex(index);
		} catch (Exception e) {
			log.info("Unable to select selectbox: " + element);
		}
	}

	public static void selectByValue(WebElement element, String inputData) {
		try {
			Select selectBox = new Select(element);
			selectBox.selectByValue(inputData);
		} catch (Exception e) {
			log.info("Unable to select selectbox: " + element);
		}
	}

	public static String selectByVisibletext(WebElement element, String inputData) {
		try {
			Select selectBox = new Select(element);
			selectBox.selectByVisibleText(inputData);
		} catch (Exception e) {
			log.info("Unable to select selectbox: " + element);
		}
		return inputData;
	}

	public static void deSelectByVisibletext(WebElement element, String inputData) {
		try {
			Select selectBox = new Select(element);
			selectBox.deselectByVisibleText(inputData);
		} catch (Exception e) {
			log.info("Unable to select selectbox: " + element);
		}
	}

	public static void deSelectByIndex(WebElement element, String inputData) {
		try {
			Integer index = new Integer(inputData);
			Select selectBox = new Select(element);
			selectBox.deselectByIndex(index);
		} catch (Exception e) {
			log.info("Unable to select selectbox: " + element);
		}
	}

	public static void deSelectByValue(WebElement element, String inputData) {
		try {
			Select selectBox = new Select(element);
			selectBox.deselectByValue(inputData);
		} catch (Exception e) {
			log.info("Unable to select selectbox: " + element);
		}
	} 

	public static String Main_Window = "";
	public static void getWindow(WebDriver driver, WebElement webElement) {  
		Main_Window = driver.getWindowHandle();
		try{Thread.sleep(1000);}catch(InterruptedException e){e.printStackTrace();}
		click(webElement);
		try{Thread.sleep(10000);}catch(InterruptedException e){e.printStackTrace();}
		ArrayList<String> allWindows=new ArrayList<String>(driver.getWindowHandles());
		allWindows.remove(Main_Window);
		driver.switchTo().window(allWindows.get(0));
	}
	
	public static String Second_Window = "";
	public static void getWindowhandles(WebDriver driver, WebElement webElement) {  
		Second_Window = driver.getWindowHandle();
		try{Thread.sleep(1000);}catch(InterruptedException e){e.printStackTrace();}
		click(webElement);
		try{Thread.sleep(10000);}catch(InterruptedException e){e.printStackTrace();}
		ArrayList<String> allWindows=new ArrayList<String>(driver.getWindowHandles());
		allWindows.remove(Main_Window);
		allWindows.remove(Second_Window);
		driver.switchTo().window(allWindows.get(0));
	}
	
	public static void switchWindow2(WebDriver driver) {  
		try{Thread.sleep(10000);}catch(InterruptedException e){e.printStackTrace();}
		ArrayList<String> allWindows=new ArrayList<String>(driver.getWindowHandles());
		allWindows.remove(Main_Window);
		driver.switchTo().window(Second_Window);			
		try{Thread.sleep(1000);}catch(InterruptedException e){e.printStackTrace();}
	}


	public static void switchWindow(WebDriver driver) {  
		driver.switchTo().window(Main_Window);			
		try{Thread.sleep(1000);}catch(InterruptedException e){e.printStackTrace();}
	}
	
	public static void switchDefaultContent(WebDriver driver) {  	 
		driver.switchTo().defaultContent();
		try{Thread.sleep(1000);}catch(InterruptedException e){e.printStackTrace();}
	}

	public static void getAutoit(WebDriver driver, String inputData) {  
		try {		
			Runtime.getRuntime().exec(inputData);		 
		} catch (IOException e1){
			e1.printStackTrace();
		}
	}

	public static void wait(WebDriver driver,String inputData) {
		try {
			int time = Integer.parseInt(inputData);
			int seconds = time*1000;
			Thread.sleep(seconds);
		} catch (InterruptedException e) {			
			e.printStackTrace();
		}
	}

	public static WebElement fromElement;
	public static void dragElement(WebDriver driver, WebElement webElement)	{
		fromElement=webElement;
	}

	public static void dropElement(WebDriver driver, WebElement webElement) {
		Actions action = new Actions(driver);
		Action dragDrop = action.dragAndDrop(fromElement, webElement).build();
		dragDrop.perform(); 
	}

	public static boolean elementIsSelected(WebDriver driver, WebElement webElement) {
		try {
			webElement.isSelected();
			return true;  
		} catch(NoSuchElementException e) {
			log.info("Unable to Select WebElement: " + webElement);
			return false;
		}    	
	}   
	
	public static boolean verifyElementIsPresent(WebDriver driver, WebElement webElement){    	
		try {			
			webElement.isDisplayed();
			if(Directory.browser.equalsIgnoreCase("firefox") || Directory.browser.equalsIgnoreCase("chrome") || Directory.browser.equalsIgnoreCase("ie")) {
				JavascriptExecutor js = (JavascriptExecutor) driver;
				js.executeScript("arguments[0].setAttribute('style', arguments[1]);",webElement, "color: red; border: 3px solid red; font-weight: bold;");
				js.executeScript("arguments[0].setAttribute('style', arguments[1]);",webElement, "");				
			}
			else {				
			}			
			return true; 
		} catch(NoSuchElementException e)   {
			log.info("Unable to Displayed WebElement: " + webElement);
			return false;
		}    	    	  
	} 
	
	public static String verifyElementIsPresentAndroid(AndroidDriver driver, WebElement webElement){    	
		try {			
			webElement.isDisplayed();
			String value = webElement.getText();			
			//((JavascriptExecutor) driver).executeScript("arguments[0].style.backgroundColor='yellow';", webElement);				
			return value; 
		} catch(NoSuchElementException e)   {
			log.info("Unable to Displayed WebElement: " + webElement);
			return "";
		}    	    	  
	} 

	public static String verifyElementIsNotPresent(WebDriver driver, WebElement webElement){
		try
		{
			WebDriverWait wait = new WebDriverWait(driver, WaitElementSeconds);
			wait.until(ExpectedConditions.not(ExpectedConditions.visibilityOf(webElement)));
		}
		catch(Exception e)
		{
			return "Verified Element is not present";
		}
		return "Verified Element is Visible";
	}	

	public static boolean elementIsEnable(WebDriver driver, WebElement webElement){
		try {
			webElement.isEnabled();         	
			return true;   
		} catch(NoSuchElementException e)  {
			log.info("Unable to Enabled WebElement: " + webElement);
			return false;
		}		
	}

	public static void visibilityElement(WebDriver driver, WebElement webElement){
		WebDriverWait wait = new WebDriverWait(driver, WaitElementSeconds);
		wait.until(ExpectedConditions.visibilityOf(webElement));			
	}	

	public static void inVisibilityElement(WebDriver driver, String NormalXpath){
		WebDriverWait wait = new WebDriverWait(driver, WaitElementSeconds);
		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath(NormalXpath)));
	}	

	public static void testIsPresent(WebDriver driver,WebElement webElement, String inputData){
		driver.getPageSource().contains(inputData);
	}

	public static void textTobePresent(WebDriver driver,WebElement webElement, String inputData){       	 
		WebDriverWait waits = new WebDriverWait(driver, WaitElementSeconds);
		waits.until(ExpectedConditions.textToBePresentInElement(webElement, inputData));    	 
	}

	public static void testIsNotPresent(WebDriver driver, String NormalXpath,String inputData){       	 
		WebDriverWait waits = new WebDriverWait(driver, WaitElementSeconds);
		waits.until(ExpectedConditions.invisibilityOfElementWithText(By.xpath(NormalXpath), inputData)); 
	}

	public static void elementTobeClickable(WebDriver driver,WebElement webElement)	{       	 
		WebDriverWait waits = new WebDriverWait(driver, WaitElementSeconds);
		waits.until(ExpectedConditions.elementToBeClickable(webElement));  
	}

	public static void elementToBeSelected(WebDriver driver,WebElement webElement)	{       	 
		WebDriverWait waits = new WebDriverWait(driver, WaitElementSeconds);
		waits.until(ExpectedConditions.elementToBeSelected(webElement));    	 
	}

	public static void waitForElement(WebDriver driver, String NormalXpath)	{   	
		WebDriverWait wait = new WebDriverWait(driver, WaitElementSeconds);   
		//wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(NormalXpath)));
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(NormalXpath)));
	}    	

	public static void waitForElementNotpresent(WebDriver driver,String NormalXpath) {    	     	 
		WebDriverWait wait = new WebDriverWait(driver, WaitElementSeconds);    	
		wait.until(ExpectedConditions.not(ExpectedConditions.presenceOfElementLocated(By.xpath(NormalXpath))));
	}

	public static void textElementPresentValue(WebDriver driver,WebElement webElement, String inputData){   	
		WebDriverWait wait = new WebDriverWait(driver, WaitElementSeconds);    	
		wait.until(ExpectedConditions.textToBePresentInElementValue(webElement, inputData));
	}    	 

	public static String linkCounts(WebDriver driver, String NormalXpath){    	
		int count = driver.findElements(By.xpath(NormalXpath)).size();
		String elementCounts = String.valueOf(count);    	
		return "Count Is :" +elementCounts;
	}

	/**
	 * Name : Gobi.E
	 * Created Date:
	 * Modified Date:
	 * Description : 
	 * Ticket ID : 
	 * Required Inputs : 
	 * Purpose : 
	 */
	public static String dynamicSendkeys(WebDriver driver,String inputData, WebElement webElement){    
		webElement.clear();
		try {Thread.sleep(1000);} catch (InterruptedException e) {e.printStackTrace();}
		//String currenttime = new SimpleDateFormat("E_yyyy_MM_dd_HH_mm_ss_a").format(Calendar.getInstance().getTime());
		String currenttime = new SimpleDateFormat("MMddHHmmssa").format(Calendar.getInstance().getTime());
		String originalValue = inputData;
		String combinedValues = originalValue+currenttime;
		sendKeys(webElement, combinedValues);		
		return combinedValues;
	}
	
	public static String dynamicMinimumSendkeys(WebDriver driver,String inputData, WebElement webElement){    
		webElement.clear();
		try {Thread.sleep(1000);} catch (InterruptedException e) {e.printStackTrace();}
		//String currenttime = new SimpleDateFormat("E_yyyy_MM_dd_HH_mm_ss_a").format(Calendar.getInstance().getTime());
		String currenttime = new SimpleDateFormat("ddHHmmssyyyy").format(Calendar.getInstance().getTime());
		String originalValue = inputData;
		String combinedValues = currenttime+originalValue;
		sendKeys(webElement, combinedValues);		
		return combinedValues;
	}

	public static void waitForAjax(WebDriver driver) {
		new WebDriverWait(driver, 180).until(new ExpectedCondition<Boolean>() {
			public Boolean apply(WebDriver driver) 	{
				JavascriptExecutor js = (JavascriptExecutor) driver;
				return (Boolean) js.executeScript("return jQuery.active == 0");
			}
		});
	}

	public static String condtionMatch(String GetText1, String GetText2){	
		String output = "";    
		System.out.println("Object is Before :" +GetText1);  		
		System.out.println("Object to After : "+GetText2);
		try	{
			if(GetText1.equalsIgnoreCase(GetText2))	{
				output = "The value"+GetText2+" is Verified"; 
			}
			return output;
		} catch(NoSuchElementException e) {
			log.info("Unable to Matched WebElement: " + output);
			return output;
		}		
	}

	/**
	 * Name:Prabakaran
	 * @param element
	 * @param imageName
	 * Created Date:17-dec-15
	 * Modified Date:18-dec-15
	 * Purpose:To send the file using relative path as inputdata
	 * @return
	 */
	public static String uploadFileSendkeys(WebElement element, String imageName){
		//		 String userDir = System.getProperty("user.dir");
		//			  String filePath = userDir  + File.separatorChar +"src"+ File.separatorChar + "main"+ File.separatorChar +"resources" + File.separatorChar + "testcases"  + File.separatorChar +"UploadFiles"+ File.separatorChar +inputData; 
		//			  Manipulation.sendKeys(element, imageName);
		String filepath=Directory.uploadFilePath+imageName;
		File fileName = new File(filepath);
		String absoultePath = fileName.getAbsoluteFile().toString();
		Manipulation.sendKeys(element,absoultePath);
		return absoultePath;
	}

	public static String uploadFileSendkeysReturnFileName1(WebElement element, String imageName){
		//		 String userDir = System.getProperty("user.dir");
		//			  String filePath = userDir  + File.separatorChar +"src"+ File.separatorChar + "main"+ File.separatorChar +"resources" + File.separatorChar + "testcases"  + File.separatorChar +"UploadFiles"+ File.separatorChar +inputData; 
		//			  Manipulation.sendKeys(element, imageName);
		String filepath=Directory.uploadFilePath+imageName;
		File fileName = new File(filepath);
		String absoultePath = fileName.getAbsoluteFile().toString();
		Manipulation.sendKeys(element,absoultePath);
		return imageName;
	}
	/**
	 * Name:Prabakaran
	 * @param driver
	 * @param inputData
	 * @param webElement
	 * Created date:24-dec-15
	 * Modified date:24-dec-15
	 * Purpose: To send dynamic key values without special characters
	 * @return
	 */
	public static String dynamicSendkeysNumbers(WebDriver driver,String inputData, WebElement webElement){    
		webElement.clear();
		try {Thread.sleep(1000);} catch (InterruptedException e) {e.printStackTrace();}
		String currenttime = new SimpleDateFormat("yyyyMMddHHmmss").format(Calendar.getInstance().getTime());
		String originalValue = inputData;
		String combinedValues = currenttime+originalValue;
		sendKeys(webElement, combinedValues);		
		return combinedValues;
	}

	public static void zoomout(WebDriver driver)
	{WebElement html = driver.findElement(By.tagName("html"));
	html.sendKeys(Keys.chord(Keys.CONTROL, Keys.SUBTRACT));
	}

	public static void HideKeboard() {
		adriver.hideKeyboard();
	}

	public static void getCurrentWindow(WebDriver driver) {  
		Main_Window = driver.getWindowHandle();		
	}

	public static String SecondWindow = "";
	public static void getSecondWindow(WebDriver driver) {
		SecondWindow = driver.getWindowHandle();		
	}

	public static void SwitchTab(WebDriver driver,String window) {
		driver.switchTo().defaultContent();
		ArrayList<String> allWindows=new ArrayList<String>(driver.getWindowHandles());
		if(window.equalsIgnoreCase("FirstWindow")) {
			driver.findElement(By.cssSelector("body")).sendKeys(Keys.CONTROL+""+Keys.PAGE_UP);
			allWindows.remove(SecondWindow);
			driver.switchTo().window(Main_Window);	
		}
		else if(window.equalsIgnoreCase("SecondWindow")) {
			driver.findElement(By.cssSelector("body")).sendKeys(Keys.CONTROL+""+Keys.PAGE_UP);
			allWindows.remove(Main_Window);
			driver.switchTo().window(SecondWindow);	
		}		 
	}

	public static void GetChromeBrowser(WebDriver chromeDriver)
	{
		//chromeDriver = new ChromeBrowser().getDriver();				
	}

	public static void GetFireFoxBrowser(WebDriver fireFoxDriver)
	{
	//	fireFoxDriver =  new FirefoxBrowser().getDriver();		 
	}

	public static void GetIEBrowser(WebDriver ieDriver)
	{
		ieDriver = new IEBrowser().getDriver();		 
	}

	public static void SwitchFireFoxBrowser(WebDriver fireFoxDriver,WebDriver chromeDriver,WebDriver ieDriver)
	{
		try
		{
			chromeDriver.manage().window().setPosition(new Point(-2000, 0));
			wait(chromeDriver, "5");
			fireFoxDriver.manage().window().setPosition(new Point(0, 0)); 
			wait(fireFoxDriver, "5");	 
		}
		catch (Exception e)
		{
			ieDriver.manage().window().setPosition(new Point(-2000, 0));
			wait(chromeDriver, "5");
			fireFoxDriver.manage().window().setPosition(new Point(0, 0)); 
			wait(fireFoxDriver, "5");	 
		}
	}

	public static void SwitchChromeBrowser(WebDriver fireFoxDriver,WebDriver chromeDriver,WebDriver ieDriver)
	{
		try
		{
			fireFoxDriver.manage().window().setPosition(new Point(-2000, 0));
			wait(chromeDriver, "5");
			chromeDriver.manage().window().setPosition(new Point(0, 0)); 
			wait(fireFoxDriver, "5");	 
		}
		catch (Exception e)
		{
			ieDriver.manage().window().setPosition(new Point(-2000, 0));
			wait(chromeDriver, "5");
			chromeDriver.manage().window().setPosition(new Point(0, 0)); 
			wait(fireFoxDriver, "5");	 
		}
	}

	public static void SwitchIEBrowser(WebDriver fireFoxDriver,WebDriver chromeDriver,WebDriver ieDriver)
	{
		try
		{
			fireFoxDriver.manage().window().setPosition(new Point(-2000, 0));
			wait(chromeDriver, "5");
			ieDriver.manage().window().setPosition(new Point(0, 0)); 
			wait(fireFoxDriver, "5");	 
		}
		catch (Exception e)
		{
			chromeDriver.manage().window().setPosition(new Point(-2000, 0));
			wait(chromeDriver, "5");
			ieDriver.manage().window().setPosition(new Point(0, 0)); 
			wait(fireFoxDriver, "5");	 
		}
	}

	public static String stringCondtionMatch(String GetText1, String GetText2){	
		String output = ""; 	
		System.out.println("Object is Before :" +GetText1);  		
		System.out.println("Object to After : "+GetText2);
		Assert.assertEquals(GetText1, GetText2);
		return "Values Matched";	
	}

	public static String checkTwoProduct(String string1, String string2)
	{
		//  System.out.println(s1);
		//  System.out.println(s2);
		string1.toUpperCase();
		if(string1.equalsIgnoreCase(string2)) 
		{
			return "Product matched";
		}
		else 
		{
			return"Product mismatched";
		}
	}
	
	public static String checkTwoValues(String string1, String string2)
	{
		  System.out.println(string1);
		  System.out.println(string2);
		//string1.toUpperCase();
		if(string1.equalsIgnoreCase(string2)) 
		{
			return "Value is matched";
		}
		else 
		{
			return"Value is  mismatched";
		}
	}
	
	public  static String getAttribute(WebDriver driver,WebElement element) {
		wait(driver, "2");
		String value = element.getAttribute("value");		  
		System.out.println("STRINGNAME "+value);
		return value;
	}
	
	public static void getNewWindow(WebDriver driver) {
		  ArrayList<String> tabs2=new ArrayList<String>(driver.getWindowHandles());
		  wait(driver, "3");
		  driver.switchTo().window(tabs2.get(1));
		  wait(driver, "3");
	}
	
	public static void browserURLSecurityException(WebDriver driver)

	{
		final String osName = Platform.OS.toUpperCase();
		Manipulation.wait(driver, "2");
		try {
			driver.findElement(By.xpath("//*[text()='Advanced']")).click();
			Manipulation.wait(driver, "2");
			driver.findElement(By.xpath("//*[text()='Add Exception…']")).click();

			if (osName.contains("WINDOWS")) {
				Manipulation.wait(driver, "1");
				Robot robot5 = null;
				try {
					robot5 = new Robot();
				} catch (AWTException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				Manipulation.wait(driver, "1");
				robot5.keyPress(KeyEvent.VK_TAB);
				Manipulation.wait(driver, "1");
				robot5.keyPress(KeyEvent.VK_TAB);
				Manipulation.wait(driver, "1");
				robot5.keyPress(KeyEvent.VK_TAB);
				Manipulation.wait(driver, "1");
				robot5.keyPress(KeyEvent.VK_TAB);
				Manipulation.wait(driver, "1");
				robot5.keyPress(KeyEvent.VK_ENTER);
				Manipulation.wait(driver, "5");
				Manipulation.wait(driver, "8");
			}

			else if (osName.contains("MAC")) {
				Robot ss;
				try {
					ss = new Robot();
					ss.mousePress(InputEvent.BUTTON1_MASK);
					ss.mouseRelease(InputEvent.BUTTON1_MASK);
					Manipulation.wait(driver, "1");
					ss.keyPress(KeyEvent.VK_ENTER);
					ss.keyRelease(KeyEvent.VK_ENTER);
					Manipulation.wait(driver, "1");
					ss.keyPress(KeyEvent.VK_CONTROL);
					System.out.println("Entered");
					ss.keyPress(KeyEvent.VK_C);
					ss.keyRelease(KeyEvent.VK_C);
					ss.keyRelease(KeyEvent.VK_CONTROL);
					Manipulation.wait(driver, "1");
				} catch (AWTException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		} catch (Exception ex) {

		}
	}


}
