package test;

import utils.MiscFuncs;
import utils.ScreenShot;
import utils.SpreadSheetReader;

import org.openqa.selenium.*;

import org.junit.BeforeClass;
import org.junit.Before;
import org.junit.Test;

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
	// private WebPage webPage;

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
		// webPage = PageFactory.initElements(webDriver, webPage.class);
		test.log(Status.PASS, "Before Class");
	}

	@Test
	public void FirstTest() {

		try {
			test.addScreenCaptureFromPath(ScreenShot.take(webDriver, "Test1 Photo"));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@Test
	public void FailTest() {
		test.log(Status.FAIL, "Forced Fail");
	}

	@Ignore
	@Test
	public void SpreadSheetTest() {

		SpreadSheetReader ssr = new SpreadSheetReader("FileNameHere");
		List<String> row = ssr.readRow(1, "Sheet 1");
		System.out.println("-Read Input-");
		for (String cell : row) {
			System.out.println(cell);
		}
		try {
			test.addScreenCaptureFromPath(ScreenShot.take(webDriver, "Test2 Photo"));
		} catch (IOException e) {
			e.printStackTrace();
		}
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
