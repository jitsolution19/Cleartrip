package com.ClearTrip.baseTest;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

public class BaseTest {
	/* ********* Report Setup ************** **/
	public ExtentReports report;
	public ExtentTest logger;
	public WebDriverWait wait;
	/* ************* WebDriver **************** */
	public static WebDriver driver;

	@BeforeTest
	public void setup() {
		report = new ExtentReports();
		logger = report.createTest("Validate Browser Setup ", "Verify Browser Selection for Execution");
		String webdriver_name = "webdriver.chrome.driver";
		String Path = System.getProperty("user.dir") + "\\src\\test\\resources\\chromedriver-win32\\chromedriver.exe";
		System.setProperty(webdriver_name, Path);
		logger.log(Status.INFO, "Browser Selected : " + "Chrome");
		ChromeOptions option = new ChromeOptions();
		option.addArguments("--remote-allow-origins=*");
		driver = new ChromeDriver(option);
		logger.log(Status.PASS, "Browser Selected Successfully ");
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		logger = report.createTest("Validate Website Launch ", "Verify Website is Launch Successfully");
		driver.navigate().to("https://www.cleartrip.com/");
		logger.log(Status.PASS, "Website Launched Successfully");
		report.removeTest(logger);
	}

	@AfterTest
	public void teardown() {
		logger = report.createTest("Validate Browser Close ", "Verify Browser close after execution");
		driver.quit();
		report.removeTest(logger);
		report.flush();
	}
}
