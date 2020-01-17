package MYFRAMEWORK.MYFRAMEWORK;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class BrowserTest {

	static Logger logger = LogManager.getLogger(BrowserTest.class);
	public static void main(String[] args) throws InterruptedException {


		System.setProperty("webdriver.gecko.driver",System.getProperty("user.dir")+ "/Drivers/GeckoDriver/geckodriver.exe");
		WebDriver driver = new FirefoxDriver();

		/*	driver.get("https://www.seleniumeasy.com/test/javascript-alert-box-demo.html");
		driver.findElement(By.xpath("//*[@id='easycont']/div/div[2]/div[3]/div[2]/button")).click();
	    Alert alert = driver.switchTo().alert();
	    Thread.sleep(3000);
	    alert.sendKeys("kavya");
	    Thread.sleep(3000);
	    alert.accept();*/
		driver.get("https://www.google.com");
		logger.info("url");
		driver.findElement(By.name("q")).sendKeys("news" + Keys.ENTER);
		logger.warn("into search");
		driver.quit();
		//driver.findElement(By.xpath("/html/body/div[6]/div[3]/div[10]/div[1]/div[2]/div/div[2]/div[2]/div/div/div/div/div[8]/div/div/div[1]/a")).click();
		//((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", ele);
		/*JavascriptExecutor js = ((JavascriptExecutor) driver);
		js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
		Thread.sleep(5000);*/

	}

}
