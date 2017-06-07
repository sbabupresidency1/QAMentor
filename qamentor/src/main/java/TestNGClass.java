import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

import org.apache.commons.io.FilenameUtils;
import org.apache.log4j.Logger;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import qa.qamentor.QAmentorReports;
import qa.qamentor.commands.Navigate;
import qa.qamentor.config.AddonsChromeBrowser;
import qa.qamentor.config.AddonsFirefoxBrowser;
import qa.qamentor.config.ChromeBrowser;
import qa.qamentor.config.EdgeBrowser;
import qa.qamentor.config.FirefoxBrowser;
import qa.qamentor.config.IEBrowser;
import qa.qamentor.config.SafariBrowser;
import qa.qamentor.datadriver.CaseStep;
import qa.qamentor.datadriver.TestCaseRunner;
import qa.qamentor.enums.LogAs;
import qa.qamentor.listeners.ConfigurationListener;
import qa.qamentor.listeners.MethodListener;
import qa.qamentor.listeners.QAmentorReportsListener;
import qa.qamentor.reports.CaptureScreen;
import qa.qamentor.reports.CaptureScreen.ScreenshotOf;
import qa.qamentor.util.ExcelUtils;
import qa.qamentor.utils.Directory;
import qa.qamentor.utils.TestParameters;

@Listeners({ ConfigurationListener.class, QAmentorReportsListener.class,
	MethodListener.class })
public class TestNGClass {
	public static int TestCaseCount = 1;
	public static String tcModuleName;
	Logger log = Logger.getLogger(TestNGClass.class.getName());
	@BeforeTest
	@DataProvider(name = "data", parallel = true)
	public static Iterator<Object[]> testCaseProvider() {
		List<Object[]> data = new ArrayList<Object[]>();
		ExcelUtils utils = new ExcelUtils();
		Collection<File> testCaseList = utils.readTestCaseFiles(Directory.testCasePath);
		Iterator<File> testCaseItr = testCaseList.iterator();

		while (testCaseItr.hasNext()) {
			String[] browser = Directory.browser.split(",");
			File tcFileName = testCaseItr.next();
			for (int i = 0; i < browser.length; i++) {
				TestParameters params = new TestParameters();
				params.setBrowserName(browser[i]);
				params.setTestCaseFileName(tcFileName);
				params.setTestCaseName(FilenameUtils.getBaseName(tcFileName
						.getName()) + "_" + browser[i]);
				String parentmodule=tcFileName.getParent();
				String[] parentpath=parentmodule.split("testcases");
				params.setModuleName(parentpath[1]);
				tcModuleName=parentpath[1];
				params.setOrSheetFileName(new File(Directory.ORSheetPath));
				data.add(new Object[] { params });
			}
		}
		return data.iterator();
	}

	@Test(dataProvider = "data", enabled = true)
	public void launchapp(TestParameters params) throws Exception {
		WebDriver driver = null;
		ExcelUtils utils = new ExcelUtils();
		try {
			if (params.getBrowserName().equals("chrome")) {
				driver = new ChromeBrowser().getDriver();
			} else if (params.getBrowserName().equals("firefox")) {
				driver =  new FirefoxBrowser().getDriver();
			} else if (params.getBrowserName().equals("ie")) {
				driver = new IEBrowser().getDriver();
			} else if (params.getBrowserName().equals("safari")) {
				driver = new SafariBrowser().getDriver();
			}else if (params.getBrowserName().equals("edge")) {
				driver = new EdgeBrowser().getDriver();
			}else if(params.getBrowserName().equalsIgnoreCase("AddonsFirefox")){
				driver =  new AddonsFirefoxBrowser().getDriver();
			}else if(params.getBrowserName().equalsIgnoreCase("AddonsChrome")){
				driver =  new AddonsChromeBrowser().getDriver();
			}

			System.out.println("Executing Testcase "+TestCaseCount+" :"+params.getTestCaseFileName());
			log.info("before set driver Thread -----"+Thread.currentThread().getId() +"------------driver------------"+driver);

			QAmentorReports.setWebDriver(driver);

			log.info("after set driver Thread -----"+Thread.currentThread().getId() +"------------driver------------"+driver);

			try {
				List<CaseStep> steps = utils.readTestCase(
						params.getTestCaseFileName(),
						params.getOrSheetFileName());
				TestCaseRunner.exectuteTestCase(driver, steps);
			} catch (NoSuchElementException e) {

				QAmentorReports.add("Failed to find Element", LogAs.FAILED,
						new CaptureScreen(ScreenshotOf.BROWSER_PAGE));

				log.info("Thread @ first close-----"+Thread.currentThread().getId() +"------------driver------------"+driver);		

				throw e;
			}
			catch (NullPointerException e){
				QAmentorReports.add("NullPointerException", LogAs.FAILED,
						new CaptureScreen(ScreenshotOf.BROWSER_PAGE));

				log.info("Thread @ first close-----"+Thread.currentThread().getId() +"------------driver------------"+driver);

				throw e; 
			}
			catch (TimeoutException e) {
				QAmentorReports.add("TimeoutException", LogAs.FAILED,
						new CaptureScreen(ScreenshotOf.BROWSER_PAGE));

				log.info("Thread @ first close-----"+Thread.currentThread().getId() +"------------driver------------"+driver);
				throw e;
			}
			catch (Exception e){

				QAmentorReports.add("Exception", LogAs.FAILED,
						new CaptureScreen(ScreenshotOf.BROWSER_PAGE));

				log.info("Thread @ first close-----"+Thread.currentThread().getId() +"------------driver------------"+driver);
				throw e;
			}		
			finally {	
				TestCaseCount++;
				Navigate.quit(driver);
				log.info("Thread @ close-----"+Thread.currentThread().getId() +"------------driver------------"+driver);
			}
		} catch (InvalidFormatException e) {
			e.printStackTrace();
		} catch (IOException e) {			
			e.printStackTrace();
		}
	}
}
