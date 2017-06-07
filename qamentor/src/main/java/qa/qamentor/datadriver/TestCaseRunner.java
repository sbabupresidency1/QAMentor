package qa.qamentor.datadriver;

/**
 * Executing and add results in reports
 */


import java.util.Iterator;
import java.util.List;
import java.util.Objects;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import qa.qamentor.QAmentorReports;
import qa.qamentor.enums.LogAs;
import qa.qamentor.util.CommandUtils;

public class TestCaseRunner {

	public static void exectuteTestCase(WebDriver driver, List<CaseStep> steps) throws Exception {
		Iterator<CaseStep> stepIterator = steps.iterator();

		while (stepIterator.hasNext()) {
			CaseStep eachStep = stepIterator.next();			
			CommandUtils util = new CommandUtils();
			WebElement element = null;
			if (eachStep.getOrLocator()!=null) {		
				try
				{
						element = util.findElement(driver, eachStep.getInputData(),eachStep.getLocateBy(),
								eachStep.getOrLocator(),eachStep.getOrLocatorStart(),eachStep.getOrLocatorMiddle(),eachStep.getOrLocatorEnd(),eachStep.getReferenceStep());
				}
				catch(NoSuchElementException exception) {
					throw exception;
				}
			}	
				Object returnObj = util.executeAction(driver, element, eachStep.getAction(),
						eachStep.getInputData(),eachStep.getStepNo(),eachStep.getReferenceStep());	    
				//QAmentorReports.add(eachStep.getAction(),eachStep.getDescription(),eachStep.getInputData(), eachStep.getExpectedResult(),Objects.toString(returnObj, ""),LogAs.PASSED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
				QAmentorReports.add(eachStep.getAction(),eachStep.getDescription(),eachStep.getInputData(), eachStep.getExpectedResult(),Objects.toString(returnObj, ""),LogAs.PASSED, null);
		}
	}
}