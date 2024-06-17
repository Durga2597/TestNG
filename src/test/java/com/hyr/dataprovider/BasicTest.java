package com.hyr.dataprovider;

import org.testng.annotations.Test;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class BasicTest {

	@Test(dataProvider = "loginData")
	public void TestLogin(String userName, String password) throws Exception{
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();

		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		Thread.sleep(5000);
		driver.findElement(By.name("username")).sendKeys(userName);
		driver.findElement(By.name("password")).sendKeys(password);
		driver.findElement(By.cssSelector(".orangehrm-login-button")).click();
		Thread.sleep(5000);
		Assert.assertTrue(driver.findElement(By.xpath("//p[contains(text(),'user')]")).isDisplayed());
		Thread.sleep(5000);
		driver.quit();
	}

	@DataProvider(parallel=true)
	public Object[][] loginData(){
		Object[][] data=new Object[6][2];
		data[0][0]="Admin";
		data[0][1]="admin123";

		data[1][0]="Admin";
		data[1][1]="test123";
		
		data[2][0]="Test";
		data[2][1]="admin123";
		
		data[3][0]="Prod";
		data[3][1]="test123";
		
		data[4][0]="Stage";
		data[4][1]="test123";
		
		data[5][0]="L6";
		data[5][1]="test123";

		return data;

	}









}
