package com.hyr.dataprovider;

import org.testng.annotations.Test;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class BasicTest5 {

	@Test(dataProvider = "getData", dataProviderClass  = ExcelDataSupplier.class)
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
}










