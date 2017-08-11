package test;

import utils.MiscFuncs;
import utils.ScreenShot;
import utils.SpreadSheetReader;

import org.openqa.selenium.*;

import org.junit.BeforeClass;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.io.IOException;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Ignore;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

public class MainTests {

	private static ExtentReports report;
	private static ExtentTest test;
	private static String reportFilePath = "TestReport.html";
	private WebDriver webDriver;
	// public int Count;
	 private AutoTraderHomePage homePage;
	 private LoginPage loginPage;
	 

	@BeforeClass
	public static void BeforeClass() {
		report = new ExtentReports();
		ExtentHtmlReporter extentHtmlReporter = new ExtentHtmlReporter(reportFilePath);
		extentHtmlReporter.config().setReportName("Main Tests Class Report");
		extentHtmlReporter.config().setDocumentTitle("Main Tests Report");
		report.attachReporter(extentHtmlReporter);
	}

	@Before
	public void Before() {
		MiscFuncs.incCounter();
		test = report.createTest("Test " + MiscFuncs.getCounter());
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--start-maximized");
		webDriver = new ChromeDriver(options);
		homePage = PageFactory.initElements(webDriver, AutoTraderHomePage.class);
		loginPage = PageFactory.initElements(webDriver, LoginPage.class);
		test.log(Status.PASS, "Before Class");	
		
		
	
	}

	@Test
	public void LoginTest() {
		ArrayList<List<String>> readData = new ArrayList<>();
		
		SpreadSheetReader ssr = new SpreadSheetReader("Data.xlsx");
		List<String> row = ssr.readRow(1, "Sheet1");
		System.out.println("--Read Input: ");
		for (String cell : row) {	
			readData.add(row);
			System.out.println(cell);	
		}


		Actions builder = new Actions(webDriver);
		webDriver.navigate().to("http://www.Autotrader.co.uk");	

		builder.moveToElement(homePage.getSignInButton()).click().perform();
		builder.moveToElement(loginPage.getSignUpButton()).click().perform();
		loginPage.getUsernameField().sendKeys(readData.get(1).get(0));
		loginPage.getPasswordField().sendKeys(readData.get(1).get(1));
		//builder.moveToElement(loginPage.getsignUpSubmitButton()).click().perform();
		WebElement tes = webDriver.findElement(By.xpath("//*[@id='js-header-nav']/ul/li[5]/div[1]/a/i"));
		
		try {
			test.addScreenCaptureFromPath(ScreenShot.take(webDriver, "Make Account"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		if(webDriver.findElement(By.cssSelector("//*[@id='js-header-nav']/ul/li[5]/div[1]/a/i")).isDisplayed()){
		  test.log(Status.PASS, "Test" + MiscFuncs.getCounter() + " Passed- ");
		  }
		  else
		  test.log(Status.FAIL, "Test Failed- ");
		 
	}
	
	@Ignore
	@Test
	public void Test2() {
		test.log(Status.INFO, "Test Not Implemented Yet");
	}
	
	@Ignore
	@Test
	public void Test3() {
		test.log(Status.INFO, "Test Not Implemented Yet");
	}
	
	@Ignore
	@Test
	public void Test4() {
		test.log(Status.INFO, "Test Not Implemented Yet");
	}
	
	@Ignore
	@Test
	public void Test5() {
		test.log(Status.INFO, "Test Not Implemented Yet");
	}
	
	@Ignore
	@Test
	public void Test6() {
		test.log(Status.INFO, "Test Not Implemented Yet");
	}
	
	@Ignore
	@Test
	public void Test7() {
		test.log(Status.INFO, "Test Not Implemented Yet");
	}
	
	@Ignore
	@Test
	public void Test8() {
		test.log(Status.INFO, "Test Not Implemented Yet");
	}
	
	@Ignore
	@Test
	public void Test9() {
		test.log(Status.INFO, "Test Not Implemented Yet");
	}
	
	@Ignore
	@Test
	public void Test10() {
		test.log(Status.INFO, "Test Not Implemented Yet");
	}


	

	@After
	public void After() {
		webDriver.quit();
		test.log(Status.INFO, "After Reached");
		report.flush();
	}

	@AfterClass
	public static void AfterClass() {

	}
}
