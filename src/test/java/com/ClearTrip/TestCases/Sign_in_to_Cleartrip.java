package com.ClearTrip.TestCases;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.ClearTrip.baseTest.BaseTest;
import com.aventstack.extentreports.Status;

public class Sign_in_to_Cleartrip extends BaseTest{
	
	@Test(dataProvider="get_credential")
	public void Sign_in(String Username,String Password)
	{
		logger=report.createTest("Validate Sign In","Verify User is able to Login Successfully");
		driver.findElement(By.xpath("//span[@class='span span19 truncate']")).click();
		driver.findElement(By.id("SignIn")).click();		
		try 
		{
			driver.switchTo().frame("modal_window");
			driver.findElement(By.xpath("//input[@name='email']")).sendKeys(Username);
			driver.findElement(By.xpath("//input[@name='password']")).sendKeys(Password);
			driver.findElement(By.id("signInButton")).click();					
			String UserName = driver.findElement(By.id("userAccountLink")).getAttribute("title");			
			logger.log(Status.PASS, "Sign In Successful"+UserName);
		}catch(Exception e)		
		{
			System.out.println(e);
			logger.log(Status.FAIL,"Sign In With Username "+Username);
		}
		report.removeTest(logger);
	}
	
	@Test
	public void Print_Exsiting_Ticket()
	{
		logger=report.createTest("Validate Print Existing Ticket ","Verify User is able Print the Existing trip ticket");
		driver.findElement(By.xpath("//span[@class='span span19 truncate']")).click();
		driver.findElement(By.xpath("//i[@class='iconSprite icoTrips']")).click();
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("trips_tab")));
		try
		{
			String Trip_details = driver.findElement(By.xpath("//a[@class='clearFix']")).getText();
			System.out.println("Trip detail : "+Trip_details);
			driver.findElement(By.xpath("//a[@class='clearFix']")).click();
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("Print e-ticket")));
			driver.findElement(By.linkText("Print e-ticket")).click();
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("Print this ticket")));
			driver.findElement(By.linkText("Print this ticket")).click();
			logger.log(Status.PASS,"Ticket Print functionality works Successfully");
		}catch(Exception e)
		{
			System.out.println(e);
			logger.log(Status.FAIL,"Ticket Print functionality works Successfully");
		}
		report.removeTest(logger);
	}	
	
	@DataProvider
	public Object[][] get_credential()
	{
		Object[][]data = new Object[1][2];
		data[0][0] ="XXXXXXXXX@gmail.com";
		data[0][1] ="XXXXXXXXX";
		return data;
		
	}
}
