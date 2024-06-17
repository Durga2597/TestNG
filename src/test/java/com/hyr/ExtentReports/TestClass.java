package com.hyr.ExtentReports;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class TestClass extends BaseTest {
	
	
	@Test(testName="TestGoogle",groups= {"smoke"})
	public void TestGoogle() throws Exception {
		driver.get("https://www.google.com/");
		extentTest.info("Navigated to Url");
		driver.findElement(By.name("q")).sendKeys("HYR Tutorials",Keys.ENTER);
		extentTest.info("Entered text in search box");
		System.out.println(driver.getTitle());
		String expectedTitle="HYR Tutorials - Google Search";
		String actualTitle=driver.getTitle();
		assertEquals(actualTitle,expectedTitle,"Title is mismatched");
		extentTest.pass("Assertion is passed for webpage title");
		
		
	}
	@Test(testName="TestFacebook",groups= {"smoke","regression"})
	public void TestFacebook() throws Exception {
		
		driver.get("https://www.facebook.com");
		extentTest.info("Navigated to Url");
		driver.findElement(By.name("email")).sendKeys("HYR Tutorials",Keys.ENTER);
		Thread.sleep(2000);
		
		SoftAssert softAssert=new SoftAssert();

		//Title assertion
		String actualTitle=driver.getTitle();
		String expectedTitle="Log in to Facebook";
		softAssert.assertEquals(actualTitle,expectedTitle,"username title is mismatched");

		//url assertion
		String actualUrl=driver.getCurrentUrl();
		String expectedUrl="https://www.facebook.com/";
		softAssert.assertNotEquals(actualUrl,expectedUrl,"username url is mismatched"); 

/*	    //text assertion
		String actualText=driver.findElement(By.id("pass")).getAttribute("value");
		String expectedText="";
		softAssert.assertEquals(actualText,expectedText,"username text is mismatched");        */

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
       
        softAssert.assertAll();

	}
	@Test(testName="TestOrangeHRM",groups= {"sanity"})
	public void TestOrangeHRM() throws Exception{
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		extentTest.info("Navigated to Url");
		Thread.sleep(2000);
		driver.findElement(By.name("username")).sendKeys("Admin");
		driver.findElement(By.name("password")).sendKeys("admin1234");
		driver.findElement(By.cssSelector(".orangehrm-login-button")).click();
		Thread.sleep(2000);
		Assert.assertTrue(driver.findElement(By.xpath("//p[contains(text(),'user')]")).isDisplayed());
		
	}
}





