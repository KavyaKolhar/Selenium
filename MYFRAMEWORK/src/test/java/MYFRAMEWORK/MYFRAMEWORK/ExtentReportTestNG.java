package MYFRAMEWORK.MYFRAMEWORK;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

public class ExtentReportTestNG {


	ExtentHtmlReporter htmlReporter;
	ExtentReports extent;
	WebDriver driver;
	

	@BeforeSuite
	public void setUp() {

		htmlReporter = new ExtentHtmlReporter("extent;Report.html");
		extent = new ExtentReports();
		extent.attachReporter(htmlReporter);
		
		
	}
	
	@BeforeTest
	public void beforeTest(){
		
		System.setProperty("webdriver.gecko.driver",System.getProperty("user.dir")+ "/Drivers/GeckoDriver/geckodriver.exe");
		driver = new FirefoxDriver();
	}


	@Test
	public void Test1() throws IOException{

		ExtentTest test = extent.createTest("Test to validate google search");


		driver.get("https://www.google.com");
		
		test.pass("test1 pass");
		//logger.info("Info");
		driver.findElement(By.name("q")).sendKeys("news" + Keys.ENTER);
		//logger.error("news entered");
		test.info("Entered text in search pass");
		test.pass("details", MediaEntityBuilder.createScreenCaptureFromPath("passSearch.png").build());
		//logger.warn("warning search page");


		test.addScreenCaptureFromPath("screenshot.png");

	}
	
	@Test
	public void Test2() throws IOException{

		ExtentTest test = extent.createTest("Test to validate google search");
		// log(Status, details)
		test.log(Status.INFO, "This step shows usage of log(status, details)");

		// info(details)
		test.info("This step shows usage of info(details)");
		System.setProperty("webdriver.gecko.driver",System.getProperty("user.dir")+ "/Drivers/GeckoDriver/geckodriver.exe");
		driver = new FirefoxDriver();
		
		driver.get("https://www.google.com");
		driver.findElement(By.name("q")).sendKeys("news" + Keys.ENTER);
		
		test.fail("details", MediaEntityBuilder.createScreenCaptureFromPath("screenshot.png").build());

		// test with snapshot
		test.addScreenCaptureFromPath("fail.png");

	}
	@AfterTest
	public void afterTest(){
		
		driver.quit();
	}

	@AfterSuite
	public void tearDown(){

		extent.flush();

	}
}
