package com.ClearTrip.TestCases;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import com.ClearTrip.baseTest.BaseTest;
import com.aventstack.extentreports.Status;

public class Register_with_Valid_Email_Id extends BaseTest{

	@Test(priority =1)
	public void New_hire()
	{
		logger=report.createTest("Validate New hire ","Verify user is able to make Registration with Valid Email Id");
		driver.findElement(By.xpath("//span[@class='span span19 truncate']")).click();		
		driver.findElement(By.linkText("Register")).click();
		wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(By.id("modal_window")));
		logger.log(Status.INFO, "Entered valid Email ID : "+"XXXXXXX@gmail.com");
		driver.findElement(By.id("username1")).sendKeys("XXXXXXX@gmail.com");
		driver.findElement(By.id("registerButton")).click();
		try
		{
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("username")));	
		}catch(Exception e)
		{
			System.out.println(e);
		}
		
		String CleartripAccount = driver.findElement(By.id("accountHead")).getText();		
		logger.log(Status.PASS,"Validate message : "+CleartripAccount);
		driver.findElement(By.id("password")).sendKeys("XXXXXXXXXX");
		logger.log(Status.INFO,"Password : "+"XXXXXXXXXX");
		Select Title = new Select(driver.findElement(By.id("profile_title")));
		Title.selectByVisibleText("Mr");
		logger.log(Status.INFO,"Title :"+"Mr");
		driver.findElement(By.xpath("//input[@name='first_name']")).sendKeys("XXXXXXXXXX");
		logger.log(Status.INFO,"First Name :"+"XXXXXXXXXX");
		driver.findElement(By.xpath("//input[@name='last_name']")).sendKeys("XXXXXXXXXX");
		logger.log(Status.INFO,"Last Name :"+"XXXXXXXXXX");
		Select Country_Code = new Select(driver.findElement(By.id("country_code")));
		Country_Code.selectByVisibleText("India(+91)");
		logger.log(Status.INFO,"Country Code :"+"India(+91)");		
		driver.findElement(By.id("mobile_number")).sendKeys("XXXXXXXXXX");
		logger.log(Status.INFO,"Mobile number :"+"XXXXXXXXXX");
		driver.findElement(By.id("signUpButton")).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[@class='span span19 truncate']")));
		String User_Email_id = driver.findElement(By.xpath("//span[@class='span span19 truncate']")).getText();
		if (User_Email_id.equals("XXXXXXXXXX@gmail.com"))
		{
			logger.log(Status.INFO,"User Email ID :"+User_Email_id);
			logger.log(Status.PASS,"Register with valid Email ID successfull :"+User_Email_id);
		}else
		{
			logger.log(Status.FAIL,"Register with valid Email ID successfull :"+User_Email_id);
		}
		report.removeTest(logger);
	}
}
