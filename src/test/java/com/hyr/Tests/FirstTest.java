package com.hyr.Tests;

import org.testng.annotations.Test;

import org.testng.asserts.SoftAssert;

import static org.testng.Assert.*;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;


public class FirstTest {

	@Test
	public void TestGoogle() throws Exception {
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.google.com");
		driver.findElement(By.name("q")).sendKeys("HYR Tutorials",Keys.ENTER);
		System.out.println(driver.getTitle());
		String expectedTitle="HVR Tutorials-Google Searchh";
		String actualTitle=driver.getTitle();
		assertEquals(actualTitle,expectedTitle,"Title is mismatched");

		Thread.sleep(1000);
		driver.quit();

	}
	@Test
	public void TestFacebook() throws Exception {
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.facebook.com");
		driver.findElement(By.name("email")).sendKeys("HYR Tutorials",Keys.ENTER);
		Thread.sleep(10000);
		
		SoftAssert softAssert=new SoftAssert();

		//Title assertion
		String actualTitle=driver.getTitle();
		String expectedTitle="Log in to Facebook";
		softAssert.assertEquals(actualTitle,expectedTitle,"username title is mismatched");

		//url assertion
		String actualUrl=driver.getCurrentUrl();
		String expectedUrl="https://www.facebook.com/";
		softAssert.assertNotEquals(actualUrl,expectedUrl,"username url is mismatched"); 

	    //text assertion
		String actualText=driver.findElement(By.id("pass")).getAttribute("value");
		String expectedText="";
		softAssert.assertEquals(actualText,expectedText,"username text is mismatched");

		//border assertion
/*		String actualBorder=driver.findElement(By.id("email")).getCssValue("border");
//		String expectedBorder="1px solid #f02849";      convert hex to rgb in google
		String expectedBorder="1px solid rgb(240, 40, 73)";
		softAssert.assertEquals(actualBorder,expectedBorder,"username Border is mismatched");      */
		
		//error message assertion
/*		String actuaErrorMessage=driver.findElement(By.xpath("//div[contains(text(),'incorrect')]")).getText();
		String expectedErrorMessage="The password that you've entered is incorrect. ";
		softAssert.assertEquals(actuaErrorMessage,expectedErrorMessage,"username Error Message is mismatched");
*/
        driver.quit();
        softAssert.assertAll();

	}
}
