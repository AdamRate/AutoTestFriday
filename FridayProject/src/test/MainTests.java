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

import static org.junit.Assert.assertEquals;

import java.io.IOException;

import org.apache.poi.util.SystemOutLogger;
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
	 private ValPage valPage;
	 static ArrayList<List<String>> readLoginData = new ArrayList<>();
	 static ArrayList<List<String>> readCarData = new ArrayList<>();
	 

	@BeforeClass
	public static void BeforeClass() {
		report = new ExtentReports();
		ExtentHtmlReporter extentHtmlReporter = new ExtentHtmlReporter(reportFilePath);
		extentHtmlReporter.config().setReportName("Main Tests Class Report");
		extentHtmlReporter.config().setDocumentTitle("Main Tests Report");
		report.attachReporter(extentHtmlReporter);
		
		SpreadSheetReader ssr = new SpreadSheetReader("Data.xlsx");
		List<String> row = ssr.readRow(1, "Sheet1");
		System.out.println("--Read Input: ");
		for (String cell : row) {	
			readLoginData.add(row);
			System.out.println(cell);	
		}
		
		List<String> rowV2 = ssr.readRow(1, "Sheet2");
		System.out.println("--Read Input: ");
		for (String cell : rowV2) {	
			readCarData.add(rowV2);
			System.out.println(cell);	
		}
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
		valPage = PageFactory.initElements(webDriver, ValPage.class);
		test.log(Status.PASS, "Before Class");	
	}

	@Ignore
	@Test
	public void LoginTest() {
		Actions builder = new Actions(webDriver);
		webDriver.navigate().to("http://www.Autotrader.co.uk");	

		builder.moveToElement(homePage.getSignInButton()).click().perform();
		builder.moveToElement(loginPage.getSignUpButton()).click().perform();
		loginPage.getUsernameField().sendKeys(readLoginData.get(2).get(0));
		loginPage.getPasswordField().sendKeys(readLoginData.get(2).get(1));
		//builder.moveToElement(loginPage.getsignUpSubmitButton()).click().perform();
		
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
	
	@Test
	public void CarSearchTest() {
		test.log(Status.INFO, "Test Not Implemented Yet");
		Actions builder = new Actions(webDriver);
		webDriver.navigate().to("http://www.Autotrader.co.uk");	
		builder.moveToElement(valPage.getSellMyCarTab()).moveToElement(valPage.getValueMyCar()).click().perform();
		//valPage.getRegNoField().sendKeys("test");
		//valPage.getMileageField().sendKeys("");
		builder.moveToElement(valPage.getRegNoField()).click().sendKeys(readCarData.get(1).get(0)).perform();
		builder.moveToElement(valPage.getMileageField()).click().sendKeys(readCarData.get(1).get(1)).perform();
		builder.moveToElement(valPage.getValuationButton()).click().perform();
		assertEquals("Search Successful", valPage.returnCarReg().getText(), readCarData.get(1).get(0));
	
	if (valPage.returnCarReg().getText().equals(readCarData.get(1).get(0))){
		test.log(Status.PASS, "Test passed for " + readCarData.get(1).get(0));
	}
	else test.log(Status.FAIL, "Test Failed for " + readCarData.get(1).get(0));
		
	}
	
	
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
