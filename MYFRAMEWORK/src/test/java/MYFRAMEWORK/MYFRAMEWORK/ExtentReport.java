package MYFRAMEWORK.MYFRAMEWORK;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

public class ExtentReport {


	static private WebDriver driver = null;
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		ExtentHtmlReporter htmlReporter = new ExtentHtmlReporter("extentReport.html");
		ExtentReports extent = new ExtentReports();
		extent.attachReporter(htmlReporter);

		ExtentTest test = extent.createTest("Test to validate google search");
		

		System.setProperty("webdriver.gecko.driver",System.getProperty("user.dir")+ "/Drivers/GeckoDriver/geckodriver.exe");
		driver = new FirefoxDriver();
		
		test.log(Status.INFO, "Starting TC for Google search");
		driver.get("https://www.google.com");
		test.pass("URL launched");
		driver.findElement(By.name("q")).sendKeys("news" + Keys.ENTER);
		test.pass("Entered text and entered search results page");
		//System.out.println("pass");
		
		driver.close();
		test.fail("failed sample");
		extent.flush();	


	}

}
