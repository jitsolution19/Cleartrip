package com.ClearTrip.TestCases;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.Test;

import com.ClearTrip.baseTest.BaseTest;
import com.aventstack.extentreports.Status;

public class Register extends BaseTest {
	@Test
	public void New_hire() {
		driver.findElement(By.xpath("//span[@class='span span19 truncate']")).click();
		driver.findElement(By.linkText("Register")).click();
		wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(By.id("modal_window")));
		logger.log(Status.INFO, "Entered Invalid Email ID : jirefdgfg@fbfg");
		driver.findElement(By.id("username1")).sendKeys("jirefdgfg@fbfg");
		driver.findElement(By.id("registerButton")).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@id='register_error']")));
		String Error_message = driver.findElement(By.xpath("//div[@id='register_error']")).getText();
		logger.log(Status.PASS, "Validate Error message :  " + Error_message);
		report.removeTest(logger);
	}
}
