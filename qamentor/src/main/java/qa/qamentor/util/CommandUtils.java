package qa.qamentor.util;

import java.util.HashMap;

import org.apache.commons.lang3.StringUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import qa.qamentor.CommonMethods.Edockets;
import qa.qamentor.commands.ElementActions;
import qa.qamentor.commands.LocatorBy;
import qa.qamentor.commands.Manipulation;
import qa.qamentor.commands.Navigate;
import qa.qamentor.commands.SikuliActions;

/**
 * Common methods for all kind of actions (Selenium Actions, CrowdTwist specific common methods)
 * @author Babu
 *
 */
public class CommandUtils {

	public WebElement element;
	public String normalXpath;
	public WebElement element1;
	public WebElement element2;
	Object returnObj = null;
	public static String getText = "";
	public static String getSize = "";
	public static HashMap<Integer, String> getTextMap = new HashMap<Integer, String>();
	public static String[] widgetUrlCount=new String[100];
	public static int widgetUrls=0;
	public static String[] splitInputData;
	public static String[] ApplicationValue=new String[100];
	public static WebDriver fireFoxDriver;
	public static WebDriver chromeDriver;
	public static WebDriver ieDriver;	
	/**
	 * Locators
	 * @param driver
	 * @param locateBy
	 * @param orLocator
	 * @return
	 */
	public WebElement findElement(WebDriver driver, String inputData, String locateBy,
			String orLocator, String orLocatorStart,String orLocatorMiddle, String orLocatorEnd, String referenceStep) {

		switch (locateBy) {
		case "ByID":
			element = LocatorBy.locateById(driver, orLocator);
			break;
		case "ByName":
			element = LocatorBy.locateByName(driver, orLocator);
			break;
		case "ByOrName":
			element = LocatorBy.locateByOrName(driver, orLocator);
			break;
		case "ByXPath":
			element = LocatorBy.locateByXPath(driver, orLocator);
			break;
		case "ByLinkText":
			element = LocatorBy.locateByLinkText(driver, orLocator);
			break;
		case "ByTagName":
			element = LocatorBy.locateByTagName(driver, orLocator);
			break;
		case "ByClassName":
			element = LocatorBy.locateByClassName(driver, orLocator);
			break;
		case "ByCssSelector":
			element = LocatorBy.locateByCssSelector(driver, orLocator);
			break;
		case "ByPartialLinkText":
			element = LocatorBy.locateByPartialLinkText(driver, orLocator);
			break;
		case "Xpath":
			normalXpath = LocatorBy.locateByNormalXpath(driver, orLocator);
			break;
		case "ByXpaths":
			element1 = LocatorBy.locateByXPath(driver, orLocatorStart);
			element2 = LocatorBy.locateByXPath(driver, orLocatorEnd);
			break;
		case "MergeByXpath":
			if (inputData == null && referenceStep != null
			&& !referenceStep.trim().equals("")) {
				int refStep = new Integer(referenceStep);
				String refText = getTextMap.get(Integer.valueOf(refStep));
				orLocator = orLocatorStart+refText+orLocatorEnd;				
				element = LocatorBy.locateByXPath(driver, orLocator);
			}
			else {
				orLocator = orLocatorStart+inputData+orLocatorEnd;				
				element = LocatorBy.locateByXPath(driver, orLocator);
			}
			break;
		case "MergeXpath":
			if (inputData == null && referenceStep != null
			&& !referenceStep.trim().equals("")) {
				int refSteps = new Integer(referenceStep);
				String refTexts = getTextMap.get(Integer.valueOf(refSteps));
				orLocator = orLocatorStart+refTexts+orLocatorEnd;				
				normalXpath = LocatorBy.locateByNormalXpath(driver, orLocator);
			}
			else {
				orLocator = orLocatorStart+inputData+orLocatorEnd;				
				normalXpath = LocatorBy.locateByNormalXpath(driver, orLocator);
			}
			break;
		case "MergeByTwoXpath":
			if (inputData == null && referenceStep != null
			&& !referenceStep.trim().equals("")) {				
				String[] splitreference=referenceStep.split(",");
				int First = new Integer(splitreference[0]);
				int Second = new Integer(splitreference[1]);
				String firstValue=getTextMap.get(Integer.valueOf(First));
				String secondValue=getTextMap.get(Integer.valueOf(Second));
				orLocator = orLocatorStart+firstValue+orLocatorMiddle+secondValue+orLocatorEnd;				
				element = LocatorBy.locateByXPath(driver, orLocator);
			}
			else {
				String[] input=inputData.split(",");
				orLocator = orLocatorStart+input[0]+orLocatorMiddle+input[1]+orLocatorEnd;				
				element = LocatorBy.locateByXPath(driver, orLocator);
			}
			break;

		default:
			break;
		}
		return element;
	}

	/**
	 * Common selenium Actions and CrowdTwist actions
	 * @param driver
	 * @param element
	 * @param action
	 * @param inputData
	 * @param stepNo
	 * @param referenceStep
	 * @return
	 * @throws Exception
	 */

	public Object executeAction(WebDriver driver, WebElement element,
			String action, String inputData, int stepNo, String referenceStep ) throws Exception {
		//Object returnObj = null;

		switch (action) {

		case "GetUrl":
			if (inputData == null && referenceStep != null
			&& !referenceStep.trim().equals(""))
			{
				int refStep = new Integer(referenceStep);
				inputData= getTextMap.get(Integer.valueOf(refStep));
			}
			Navigate.get(driver, inputData);
			break;
		case "NavigateToURL":
			Navigate.navigateUrl(driver,inputData);
			break;	
		case "Wait":
			Manipulation.wait(driver, inputData);
			break;
		case "WaitTime":
			Navigate.waitTime(driver, inputData);
			break;
		case "Maximize":
			Navigate.maximize(driver);
			break;
		case "Click":
			Manipulation.click(element);
			break;
		case "ActionClick":
			Manipulation.actionClick(driver,element);
			break;
		case "JsClick":
			Manipulation.jsClickByXPath(driver, normalXpath);
			break;
		case "JsType":
			Manipulation.jsTypeByXPath(driver, normalXpath,inputData);
			break;
		case "DoubleClick":
			Manipulation.doubleClick(driver, element);
			break;
		case "ClickAt":
			String[] coordinates = StringUtils.split(inputData, ",");
			int x = new Integer(coordinates[0]);
			int y = new Integer(coordinates[1]);
			Manipulation.clickAt(driver, element, x, y);
			break;
		case "ClickAndHold":
			Manipulation.clickAndHold(driver, element);
			break; 
		case "Clear":
			Manipulation.clear(element);
			break;
		case "Type":
			if (inputData == null && referenceStep != null
			&& !referenceStep.trim().equals(""))
			{
				int refStep = new Integer(referenceStep);
				inputData= getTextMap.get(Integer.valueOf(refStep));
			}
			returnObj=Manipulation.sendKeys(element, inputData);
			getTextMap.put(stepNo, returnObj.toString());
			break;
		case "ClearAndType":
			if (inputData == null && referenceStep != null
			&& !referenceStep.trim().equals(""))
			{
				int refStep = new Integer(referenceStep);
				inputData= getTextMap.get(Integer.valueOf(refStep));
			}
			returnObj=Manipulation.clearAndType(element,inputData);			
			getTextMap.put(stepNo, returnObj.toString());
			break;
		case "ActionType":
			if (inputData == null && referenceStep != null
			&& !referenceStep.trim().equals(""))
			{
				int refStep = new Integer(referenceStep);
				inputData= getTextMap.get(Integer.valueOf(refStep));
			}
			returnObj=Manipulation.actionType(driver,element, inputData);
			getTextMap.put(stepNo, returnObj.toString());
			break;
		case "TypeDynamicValue":
			returnObj = Manipulation.dynamicSendkeys(driver ,inputData, element);
			getTextMap.put(stepNo, returnObj.toString());
			break;	
		case "TypeDynamicMinimumValue":
			returnObj = Manipulation.dynamicMinimumSendkeys(driver ,inputData, element);
			getTextMap.put(stepNo, returnObj.toString());
			break;	
		case "Submit":
			Manipulation.submit(element);
			break;
		case "MouseOver":
			Manipulation.mouseOver(driver, element);
			break;
		case "MouseOverAndClick":
			Manipulation.mouseOverAndClick(driver, element);
			break;
		case "GetText":
			returnObj = ElementActions.getText(element);
			getText = returnObj.toString();	
			getTextMap.put(stepNo, returnObj.toString());				
			break;
		case "GetAttribute":
			returnObj = ElementActions.getAttribute(element, inputData);
			break;		
		case "GetCount":
			returnObj = Manipulation.linkCounts(driver, normalXpath);			
			getTextMap.put(stepNo, returnObj.toString());
			break;
		case "GetCurrentURL":
			returnObj = Manipulation.getCurrentURL(driver);
			getTextMap.put(stepNo, returnObj.toString());
			break;
		case "SelectCheckBox":
			Manipulation.selectCheckBox(element);
			break;		
		case "SelectByIndex":
			Manipulation.selectByIndex(element, inputData);
			break;
		case "SelectByValue":
			Manipulation.selectByValue(element, inputData);
			break;
		case "SelectByVisibleText":		
			if (inputData == null && referenceStep != null && !referenceStep.trim().equals("")) {
				int refStep1 = new Integer(referenceStep);			
				String getText1 = getTextMap.get(Integer.valueOf(refStep1));				
				returnObj = Manipulation.selectByVisibletext(element,getText1);
				getTextMap.put(stepNo, returnObj.toString());
			} else {				
				returnObj = Manipulation.selectByVisibletext(element,inputData);
				getTextMap.put(stepNo, returnObj.toString());
			}
			break;
		case "DeSelectCheckBox":
			Manipulation.deSelectCheckBox(element);
			break;
		case "DeSelectByIndex":
			Manipulation.deSelectByIndex(element, inputData);
			break;
		case "DeSelectByValue":
			Manipulation.deSelectByValue(element, inputData);
			break;
		case "DeSelectByVisibleText":
			if (inputData == null && referenceStep != null && !referenceStep.trim().equals("")) 
			{
				int refStep1 = new Integer(referenceStep);			
				String getText1 = getTextMap.get(Integer.valueOf(refStep1));				
				Manipulation.deSelectByVisibletext(element, getText1);
			} 
			else {
				Manipulation.deSelectByVisibletext(element, inputData);
			}
			break;			
		case "SwitchFrameByName":
			Navigate.switchToFrame(driver, inputData);
			break;
		case "SwitchFrameByIndex":
			int index = new Integer(inputData);
			Navigate.switchToFrame(driver, index);
			break;
		case "SwitchFrameByXpath":
			Navigate.switchToFrame(driver, element);
			break;
		case "SwitchFrame":
			Navigate.switchToFrame2(driver);
			break;
		case "SwitchToDefaultFrame":			
			Navigate.switchToDefaultFrame(driver);
			break;			
		case "Refresh":
			Navigate.refreshPage(driver);
			break;
		case "Back":
			Navigate.goBack(driver);
			break;
		case "Forward":
			Navigate.goForward(driver);
			break;
		case "AlertOk":
			returnObj = Navigate.alertOk(driver, element);
			break;	    
		case "DismissAlert":
			returnObj = Navigate.dismissAlert(driver);
			break;  	    
		case "AlertDismiss":
			returnObj = Navigate.alertDismiss(driver, element);
			break;
		case "PromptBox":
			returnObj = Navigate.promptBox(driver, element, inputData);
			break;		
		case "GenerateAlert":
			Navigate.alertGenerate(driver,inputData);
			break;			
		case "Close":
			Navigate.close(driver);
			break;		
		default:
			break;
		case "GetWindowHandle":
			Manipulation.getWindow(driver, element);
			break;
		case "GetSecondWindowHandle":
			Manipulation.getWindowhandles(driver, element);
			break;
		case "SwitchToSecondWindow":
			Manipulation.switchWindow2(driver);
			break;	
		case "SwitchToDefaultWindow":
			Manipulation.switchWindow(driver);
			break;	
		case "SwitchToDefaultContent":
			Manipulation.switchDefaultContent(driver);
			break;
		case "GetAutoIt":
			Manipulation.getAutoit(driver, inputData);
			break;
		case "ScrollDown":
			Navigate.pageDown(driver);
			break;
		case "ScrollUp":
			Navigate.pageUp(driver);
			break;
		case "ScrollBottom":
			Navigate.scrollBottom(driver);
			break;      
		case "KeyboardPageUp":
			Navigate.keyboardPageUp(driver);
			break;
		case "KeyboardPageDown":
			Navigate.keyboardPageDown(driver);
			break;
		case "KeyboardEnd":
			Navigate.keyboardEnd(driver);
			break;	
		case "KeyboardTab":
			Navigate.keyboardTab(driver);
			break;		
		case "PageMaximize":
			Navigate.pageMaximize(driver);
			break;	
		case "Enter":
			Navigate.enter(driver);
			break;	
		case "KeyboardArrowUp":
			Navigate.keyboardArrowUp(driver);
			break;	
		case "KeyboardArrowDown":
			Navigate.keyboardArrowDown(driver);
			break;	
		case "KeyboardArrowLeft":
			Navigate.keyboardArrowLeft(driver);
			break;	
		case "KeyboardArrowRight":
			Navigate.keyboardArrowRight(driver);
			break;			
		case "Drag":
			Manipulation.dragElement(driver, element);
			break;
		case "Drop":
			Manipulation.dropElement(driver, element);
			break;		
		case "VerifyElementIsSelected":
			Manipulation.elementIsSelected(driver, element);
			break;
		case "VerifyElementIsPresent":
			Manipulation.verifyElementIsPresent(driver, element);
			break;
		case "VerifyElementIsNotPresent":
			returnObj = Manipulation.verifyElementIsNotPresent(driver, element);
			break;
		case "VerifyElementIsEnable":
			Manipulation.elementIsEnable(driver, element);
			break;		
		case "WaitUntilVisibilityOfElement":
			Manipulation.visibilityElement(driver, element);
			break;	
		case "WaitUntilInvisibilityOfElement":
			Manipulation.inVisibilityElement(driver, normalXpath);
			break;			
		case "VerifyTextIsPresent":
			Manipulation.testIsPresent(driver,element, inputData);
			break;	
		case "WaitUntilTextToBeNotPresent":
			Manipulation.testIsNotPresent(driver,normalXpath, inputData);
			break;		
		case "WaitUntilTextToBePresent":
			Manipulation.textTobePresent(driver,element, inputData);
			break;	
		case "WaitUntilElementToBeClickable":
			Manipulation.elementTobeClickable(driver,element);
			break;	
		case "WaitUntilElementToBeSelected":
			Manipulation.elementToBeSelected(driver,element);
			break;	
		case "TextToBePresentInElementValue":
			Manipulation.textElementPresentValue(driver,element,inputData);
			break;		
		case "WaitForElementPresent":
			Manipulation.waitForElement(driver, normalXpath);
			break;
		case "WaitForElementNotPresent":
			Manipulation.waitForElementNotpresent(driver,normalXpath);
			break;	
		case "CheckTwoString":
			if (inputData == null && referenceStep != null
			&& !referenceStep.trim().equals("")) {
				String[] referenceSteps = StringUtils.split(referenceStep, ",");
				int refStep1 = new Integer(referenceSteps[0]);
				int refStep2 = new Integer(referenceSteps[1]);
				String getText1 = getTextMap.get(Integer.valueOf(refStep1));
				String getText2 = getTextMap.get(Integer.valueOf(refStep2));
				returnObj = Manipulation.condtionMatch(getText1, getText2);
			}
			else /*if(inputData != null && referenceStep != null && !referenceStep.trim().equals(""))*/
			{
				int refStep2 = new Integer(referenceStep);
				String getText1 = getTextMap.get(Integer.valueOf(refStep2));
				returnObj = Manipulation.condtionMatch(inputData,getText1);		
			}
			break;		
		case "DeleteAllCookies":
			Navigate.deleteAllCookies(driver);
			break;			
		case "TakeScreeShot":
			Navigate.screenShot(driver,inputData);
			break;					
		case "Highlight":
			Navigate.highLightElement(driver,element);
			break;	
		case "NewTab":
			Navigate.newTab(driver);
			break;
		case "CloseTab":
			Navigate.closeTab(driver);
			break;	
		case "WaitForAjaxQuery":
			Manipulation.waitForAjax(driver);
			break;	
		case "SendHttpPost":
			returnObj=Navigate.sendHttpPost(inputData);
			break;
		case "SplitAndOpenURL":
			if (inputData == null && referenceStep != null
			&& !referenceStep.trim().equals("")) {
				int refStep = new Integer(referenceStep);
				String getText=getTextMap.get(Integer.valueOf(refStep));				
				String[] openURL = getText.split("https://www.google.de/");				
				driver.get(openURL[0]);
			}
			break;			

		case "ConcatStrings":
			String concat="";
			if (inputData == null && referenceStep != null
					&& !referenceStep.trim().equals("")){
				String[] splitReference=referenceStep.split(",");
				int size=splitReference.length;
				for(int i=0;i<size;i++){
					String getText12=getTextMap.get(Integer.valueOf(splitReference[i]));
					concat=concat+getText12;
				}
			}
			if (inputData != null && referenceStep == null
					&& !inputData.trim().equals("")) {
				splitInputData=inputData.split(",");
				int size=splitInputData.length;
				for(int i=0;i<size;i++)
				{
					concat=concat+splitInputData[i];
				}	
			}
			System.out.println(concat);
			returnObj=concat;
			break;
		case "Concat2String":
			String[] splitreference=referenceStep.split(",");
			int refStep12 = new Integer(splitreference[0]);
			int refStep13 = new Integer(splitreference[1]);
			String getText12=getTextMap.get(Integer.valueOf(refStep12));
			String getText13=getTextMap.get(Integer.valueOf(refStep13));
			String con = getText12.concat(getText13);
			returnObj=con;

		case "DynamicSendKeys":
			returnObj=Manipulation.dynamicSendkeysNumbers(driver, inputData, element);
			getTextMap.put(stepNo, returnObj.toString());
			break;
		case "UploadFileUsingSendkeys":
			returnObj=Manipulation.uploadFileSendkeys(element, inputData);
			getTextMap.put(stepNo, returnObj.toString());
			break;	
		case "UploadFileReturnFileName":
			returnObj=Manipulation.uploadFileSendkeysReturnFileName1(element, inputData);
			getTextMap.put(stepNo, returnObj.toString());
			break;
		case"ZoomOut":
			Manipulation.zoomout(driver);
			break;
		case"ReplaceSpecialCharacters":
			if (inputData == null && referenceStep != null
			&& !referenceStep.trim().equals("")){				
				int input = new Integer(referenceStep);				
				String value=getTextMap.get(Integer.valueOf(input));
				String splitReference=value.replace(";", "");
				returnObj=splitReference;
				getTextMap.put(stepNo, returnObj.toString());
			}			
			break;
		case "KeyboardHide":		
			Manipulation.HideKeboard(); 			   
			break;
		case "GetCurrentWindow":
			Manipulation.getCurrentWindow(driver);
			break;
		case "GetSecondWindow":
			Manipulation.getSecondWindow(driver);
			break;
		case "SwitchWindow":
			Manipulation.SwitchTab(driver, inputData);	
			break;
		case "ChromeBrowser":
			Manipulation.GetChromeBrowser(chromeDriver);	
			break;
		case "FireFoxBrowser":
			Manipulation.GetFireFoxBrowser(fireFoxDriver);	
			break;
		case "IEBrowser":
			Manipulation.GetIEBrowser(ieDriver);	
			break;
		case "SwitchChromeBrowser":
			Manipulation.SwitchChromeBrowser(fireFoxDriver,chromeDriver,ieDriver);	
			break;
		case "SwitchFireFoxBrowser":
			Manipulation.SwitchFireFoxBrowser(fireFoxDriver,chromeDriver,ieDriver);	
			break;
		case "SwitchIEBrowser":
			Manipulation.SwitchIEBrowser(fireFoxDriver,chromeDriver,ieDriver);	
			break;
		case "CheckStringValues":
			if (inputData == null && referenceStep != null
			&& !referenceStep.trim().equals("")) {
				String[] referenceSteps = StringUtils.split(referenceStep, ",");
				int refStep1 = new Integer(referenceSteps[0]);
				int refStep2 = new Integer(referenceSteps[1]);
				String getText1 = getTextMap.get(Integer.valueOf(refStep1));
				String getText2 = getTextMap.get(Integer.valueOf(refStep2));
				returnObj = Manipulation.stringCondtionMatch(getText1, getText2);
			}
			else /*if(inputData != null && referenceStep != null && !referenceStep.trim().equals(""))*/
			{
				int refStep2 = new Integer(referenceStep);
				String getText1 = getTextMap.get(Integer.valueOf(refStep2));
				returnObj = Manipulation.stringCondtionMatch(inputData,getText1);		
			}
			break;		
			/////////////////////////////////
		case "CheckProduct":
			String[] splitReferenceNum=referenceStep.split(",");
			int product1RefStep = new Integer(splitReferenceNum[0]);
			int productRefStep = new Integer(splitReferenceNum[1]);
			String product1=getTextMap.get(Integer.valueOf(product1RefStep));
			String product2=getTextMap.get(Integer.valueOf(productRefStep));
			returnObj = Manipulation.checkTwoProduct(product1, product2);
			break;
		case "CheckTwoStringValues":
			String[] splitReferenceNum1=referenceStep.split(",");
			int product1RefStep1 = new Integer(splitReferenceNum1[0]);
			int productRefStep1 = new Integer(splitReferenceNum1[1]);
			String product11=getTextMap.get(Integer.valueOf(product1RefStep1));
			String product21=getTextMap.get(Integer.valueOf(productRefStep1));
			returnObj = Manipulation.checkTwoValues(product11, product21);
			break;
		case "HandleSecondWindow":
			Navigate.handlesecondWindow(driver,element);		
			break;
		case "SwitchSecondWindow":
			Navigate.switchSecondWindow(driver);		
			break;
		case "SwitchMainWindow":
			Navigate.MainWindow(driver);
			break;
		case "ScrollToView":
			Navigate.scrollToView(driver, element);
			break;	
		case "SplitStringValues":
			int refStep = new Integer(referenceStep);
			String inputValue= getTextMap.get(Integer.valueOf(refStep));
			returnObj=Navigate.splitValues(inputValue, inputData);
			getTextMap.put(stepNo, returnObj.toString());
			break;
		/*case "EdocketsLogin":			
			Edockets.EdocketsLoging(driver);
			break;*/
		case "ClickSaveButton":
			Edockets.doubleclick(driver, element);
			break;
		case "CloseOpenTab":
			Edockets.closeTab(driver);
			break;
		case "SikuliType":
			if (inputData != null && referenceStep == null){
			String[] values = inputData.split(",");
			System.out.println(values[0]);
			System.out.println(values[1]);
			SikuliActions.type(values[0], values[1]); }
			else if (inputData != null && referenceStep != null
					&& !referenceStep.trim().equals("")){
				int refStepValue = new Integer(referenceStep);
				String refValue= getTextMap.get(Integer.valueOf(refStepValue));
				SikuliActions.type(inputData, refValue);
			}
			break;
		case "SikuliClick":
			SikuliActions.click(inputData);
			break;
		case "EDocketsLogin":
			String[] values = inputData.split(",");
			Edockets.edocketLogIn(driver,values[0],values[1]);
			break;
		case "RobotEnter":
			Navigate.robotEnter(driver);
			break;
		case "RobotTab":
		    Navigate.robotTab(driver);
		    break;
		case "GetAttributeValue":
			returnObj =Manipulation.getAttribute(driver, element);
			getTextMap.put(stepNo, returnObj.toString());
			break;
		case "GetNewWindow":
			Manipulation.getNewWindow(driver);
			break;
		case "SplitDetails":
			if (inputData == null && referenceStep != null
			&& !referenceStep.trim().equals("")) {
				int refStepValue = new Integer(referenceStep);
				String refValue= getTextMap.get(Integer.valueOf(refStepValue));
				returnObj=Manipulation.splitDetails(driver,refValue);
				getTextMap.put(stepNo, returnObj.toString());
				break;
			}	

		}
		return returnObj;
	}
}
